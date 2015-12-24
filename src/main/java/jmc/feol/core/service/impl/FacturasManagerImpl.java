package jmc.feol.core.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jmc.feol.core.dao.CotDAO;
import jmc.feol.core.dao.FacturaDAO;
import jmc.feol.core.model.Cot;
import jmc.feol.core.model.Empresa;
import jmc.feol.core.model.Factura;
import jmc.feol.core.service.EmpresaManager;
import jmc.feol.core.service.FacturaManager;
import jmc.feol.core.service.FacturasManager;
import jmc.feol.core.service.ParametrizacionManager;
import jmc.feol.util.Constants;
import jmc.feol.util.FileUtil;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType;

/**
 * Clase que implementa los servicios referentes a Remitos
 * 
 * @author Juan Manuel Carrascal.
 */
public class FacturasManagerImpl implements FacturasManager {

	private ParametrizacionManager parametrizacionManager;
	private FacturaDAO extendedFacturaDAO;
	private FacturaManager facturaManager;
	private EmpresaManager empresaManager;
	private CotDAO extendedCotDAO;

	public CotDAO getExtendedCotDAO() {
		return extendedCotDAO;
	}

	public void setExtendedCotDAO(CotDAO extendedCotDAO) {
		this.extendedCotDAO = extendedCotDAO;
	}

	public EmpresaManager getEmpresaManager() {
		return empresaManager;
	}

	public void setEmpresaManager(EmpresaManager empresaManager) {
		this.empresaManager = empresaManager;
	}

	public FacturaManager getFacturaManager() {
		return facturaManager;
	}

	public void setFacturaManager(FacturaManager facturaManager) {
		this.facturaManager = facturaManager;
	}

	public FacturaDAO getExtendedFacturaDAO() {
		return extendedFacturaDAO;
	}

	public void setExtendedFacturaDAO(FacturaDAO extendedFacturaDAO) {
		this.extendedFacturaDAO = extendedFacturaDAO;
	}

	public ParametrizacionManager getParametrizacionManager() {
		return parametrizacionManager;
	}

	public void setParametrizacionManager(
			ParametrizacionManager parametrizacionManager) {
		this.parametrizacionManager = parametrizacionManager;
	}

	public List<Factura> getFacturaGrilla(String propertySort,
			String orderSort, String[] propertyFilter, String[] valueFilter,
			Integer min, Integer max) throws Exception {

		List<Factura> facturas = new ArrayList<Factura>();

		if (propertySort == null || propertySort.trim().equals("")) {
			propertySort = "fecha_creacion";
			orderSort = "desc";

		}
		facturas = extendedFacturaDAO.getFacturaGrilla(1l, propertySort,
				orderSort, propertyFilter, valueFilter, min, max);

		return facturas;
	}

	public List<Cot> getCotGrilla(String propertySort, String orderSort,
			String[] propertyFilter, String[] valueFilter, Integer min,
			Integer max) throws Exception {

		List<Cot> cots = new ArrayList<Cot>();

		if (propertySort == null || propertySort.trim().equals("")) {
			propertySort = "fecha_creacion";
			orderSort = "desc";

		}
		cots = extendedCotDAO.getCotGrilla(1l, propertySort, orderSort,
				propertyFilter, valueFilter, min, max);

		return cots;
	}

	public void reProcesarFactura(String nombreArchivo) {
		// Copio el Archivo que se encuentra en la carpeta Definitivo en la
		// carpeta provisorio
		File fileProvisorio = new File(
				parametrizacionManager.getParametrizacionByPrimaryKey(
						Constants.ID_CARPETA_PROVISORIO).getValor()
						+ nombreArchivo);
		File fileDefinitivo = new File(
				parametrizacionManager.getParametrizacionByPrimaryKey(
						Constants.ID_CARPETA_DEFINITIVO).getValor()
						+ nombreArchivo);

		try {
			FileUtil.copy(fileDefinitivo, fileProvisorio);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(15000l);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public Long getCountFacturaGrilla() {
		return extendedFacturaDAO.getCountFacturaGrilla(1l);
	}

	public Long getCountCotGrilla() {
		return extendedCotDAO.getCountCotGrilla(1l);
	}

	public List<String> getFacturasOrdenadas(String fechadesde) {
		// Obtengo las facturas Ordenadas
		List<Factura> facturas = extendedFacturaDAO.getFacturasPerdidas(fechadesde);

		//
		boolean primer = true;
		Long numeroComprobante = 0l;
		Long numeroComprobanteAnterior = 0l;
		Integer tipoComprobanteFijo = 0;
		Integer prefijoFijo = 0;
		Empresa empresa = empresaManager.getByPrimaryKey(1l);
		List<String> listFacturasPerdidas = new ArrayList<String>();
		for (Factura factura : facturas) {
			if (primer) {
				numeroComprobante = factura.getCbt_desde();
				numeroComprobanteAnterior = numeroComprobante;
				prefijoFijo = factura.getPunto_vta();
				tipoComprobanteFijo = factura.getTipo_cbte();
				primer = false;
			} else {
				// Si es el mismo Prefijo y tipoCompro
				if (factura.getTipo_cbte().equals(tipoComprobanteFijo)
						&& factura.getPunto_vta().equals(prefijoFijo)) {
					if ((numeroComprobanteAnterior + 1) == factura
							.getCbt_desde()) {

					} else {
						// Busco si las siguientes Facturas Existen
						boolean termino = false;
						int j = 0;
						Long numeroComprobanteTemp = numeroComprobanteAnterior;
						numeroComprobanteTemp++;
						while (j < 20 && !termino) {
							String valor = extendedFacturaDAO.getByPKAfip(
									prefijoFijo, tipoComprobanteFijo,
									numeroComprobanteTemp);
							if (valor == null || valor.trim().equals("")) {

								String response = getTransacFacturaRepetida(
										prefijoFijo, tipoComprobanteFijo,
										numeroComprobanteTemp, empresa);

								String result = prefijoFijo + ";"
										+ tipoComprobanteFijo + ";"
										+ (numeroComprobanteTemp) + ";"
										+ response;

								listFacturasPerdidas.add(result);

								System.out.println(result);

							} else {

							}
							numeroComprobanteTemp++;

							if (numeroComprobanteTemp.equals(factura
									.getCbt_desde())) {
								termino = true;

							}
							j++;

						}

					}
					numeroComprobanteAnterior = factura.getCbt_desde();
					// numeroComprobanteAnterior++;
				} else {
					numeroComprobante = factura.getCbt_desde();
					numeroComprobanteAnterior = numeroComprobante;
					prefijoFijo = factura.getPunto_vta();
					tipoComprobanteFijo = factura.getTipo_cbte();
				}

			}

		}

		return listFacturasPerdidas;
	}

	private String getTransacFacturaRepetida(Integer prefijo,
			Integer comprobanteTipo, Long nroComprobante, Empresa empresa) {
		String result = "";
		Long nroComprobanteAdd = nroComprobante;

		nroComprobanteAdd++;

		try {
			if (empresa.getService().equals("wsmtxca")) {
				ConsultarComprobanteResponseType feRes = facturaManager
						.getFacturaMTX(nroComprobante,
								comprobanteTipo, prefijo, empresa);
				result = result + feRes.getComprobante().getCodigoAutorizacion()
						+ ";" + feRes.getComprobante().getFechaVencimiento() + ";"
						+ feRes.getComprobante().getImporteTotal().toString() + ";"
						+ feRes.getComprobante().getImporteGravado() + ";"
						+ feRes.getComprobante().getImporteOtrosTributos() + ";"
						+ feRes.getComprobante().getImporteNoGravado() + ";"
						+ feRes.getComprobante().getNumeroDocumento() + ";"
						+ feRes.getComprobante().getCodigoTipoDocumento() + ";"
						+ feRes.getComprobante().getFechaEmision();
				
			} else {
				FECompConsultaResponse feRes = facturaManager
						.getComprobanteByPrimary(nroComprobante,
								comprobanteTipo, prefijo, empresa);
				result = result + feRes.getResultGet().getCodAutorizacion()
						+ ";" + feRes.getResultGet().getFchVto() + ";"
						+ feRes.getResultGet().getImpTotal() + ";"
						+ feRes.getResultGet().getImpNeto() + ";"
						+ feRes.getResultGet().getImpTrib() + ";"
						+ feRes.getResultGet().getImpIVA() + ";"
						+ feRes.getResultGet().getDocNro() + ";"
						+ feRes.getResultGet().getDocTipo() + ";"
						+ feRes.getResultGet().getCbteFch();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void reProcesarFactura(Factura facturaActual) {
		File fileProvisorio = null;
		File fileDefinitivo = null;
		if (facturaActual.getMetodoAfip().equals("LOCAL")) {
			// Copio el Archivo que se encuentra en la carpeta Definitivo en la
			// carpeta provisorio
			fileProvisorio = new File(parametrizacionManager
					.getParametrizacionByPrimaryKey(
							Constants.ID_CARPETA_PROVISORIO).getValor()
					+ facturaActual.getNombreArchivo());
			fileDefinitivo = new File(parametrizacionManager
					.getParametrizacionByPrimaryKey(
							Constants.ID_CARPETA_DEFINITIVO).getValor()
					+ facturaActual.getNombreArchivo());
		} else {
			// Copio el Archivo que se encuentra en la carpeta Definitivo en la
			// carpeta provisorio
			fileProvisorio = new File(parametrizacionManager
					.getParametrizacionByPrimaryKey(
							Constants.ID_CARPETA_PROVISORIO_EXPOV1).getValor()
					+ facturaActual.getNombreArchivo());
			fileDefinitivo = new File(parametrizacionManager
					.getParametrizacionByPrimaryKey(
							Constants.ID_CARPETA_DEFINITIVO_EXPOV1).getValor()
					+ facturaActual.getNombreArchivo());
		}

		try {
			FileUtil.copy(fileDefinitivo, fileProvisorio);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(15000l);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
