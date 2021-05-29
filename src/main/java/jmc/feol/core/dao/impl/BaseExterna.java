package jmc.feol.core.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import FEV1.dif.afip.gov.ar.AlicIva;
import FEV1.dif.afip.gov.ar.CbteAsoc;
import FEV1.dif.afip.gov.ar.FECAECabRequest;
import FEV1.dif.afip.gov.ar.FECAEDetRequest;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.Tributo;
import jmc.feol.core.model.Usuario;
import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.DateUtil;
import jmc.feol.util.FormatUtil;

public class BaseExterna {
	private Boolean actualizoBase = Boolean.FALSE;
	private String urlBase = "";
	private String base = "";
	private String usuario = "";
	private String usuarioClave = "";
	private String tabla = "";

	private String controlador = "";
	private String prefijo = "";
	private String campoNumCot = "";
	private String campoRespuestaRentas = "";
	private String campoRemito = "";
	private String rutaComun = "";
	private String rutaArticulo = "";
	private String usr = "";
	private String password = "";
	private Boolean useSQL = Boolean.FALSE;

	public Boolean getUseSQL() {
		return useSQL;
	}

	public void setUseSQL(Boolean useSQL) {
		this.useSQL = useSQL;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRutaComun() {
		return rutaComun;
	}

	public void setRutaComun(String rutaComun) {
		this.rutaComun = rutaComun;
	}

	public String getRutaArticulo() {
		return rutaArticulo;
	}

	public void setRutaArticulo(String rutaArticulo) {
		this.rutaArticulo = rutaArticulo;
	}

	public BaseExterna(String contralador, String urlBase) {
		this.setUrlBase(urlBase);
		this.setControlador(contralador);
	}

	public BaseExterna(String contralador, String urlBase, String rutaComun, String rutaArticulo) {
		this.setUrlBase(urlBase);
		this.setControlador(contralador);
		this.setRutaArticulo(rutaArticulo);
		this.setRutaComun(rutaComun);
	}

	public BaseExterna(String contralador, String urlBase, String rutaComun, String rutaArticulo, String usr,
			String password) {
		this.setUrlBase(urlBase);
		this.setControlador(contralador);
		this.setRutaArticulo(rutaArticulo);
		this.setRutaComun(rutaComun);
		this.setUsr(usr);
		this.setPassword(password);
		this.useSQL = true;
	}

	public Boolean getActualizoBase() {
		return actualizoBase;
	}

	public void setActualizoBase(Boolean actualizoBase) {
		this.actualizoBase = actualizoBase;
	}

	public String getUrlBase() {
		return urlBase;
	}

	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioClave() {
		return usuarioClave;
	}

	public void setUsuarioClave(String usuarioClave) {
		this.usuarioClave = usuarioClave;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getControlador() {
		return controlador;
	}

	public void setControlador(String controlador) {
		this.controlador = controlador;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getCampoNumCot() {
		return campoNumCot;
	}

	public void setCampoNumCot(String campoNumCot) {
		this.campoNumCot = campoNumCot;
	}

	public String getCampoRespuestaRentas() {
		return campoRespuestaRentas;
	}

	public void setCampoRespuestaRentas(String campoRespuestaRentas) {
		this.campoRespuestaRentas = campoRespuestaRentas;
	}

	public String getCampoRemito() {
		return campoRemito;
	}

	public void setCampoRemito(String campoRemito) {
		this.campoRemito = campoRemito;
	}

	public Connection getConnMDB(String rutaBase) {

		if (useSQL) {
			String direccion = urlBase;
			try {
				Class.forName(controlador);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(direccion, usr, password);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				conn.getAutoCommit();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return conn;

		} else {
			String direccion = urlBase.replaceFirst("@rutaBase", rutaBase);
			try {
				Class.forName(controlador);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(direccion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.getAutoCommit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
	}

	private FECAERequest makeFECAERequest(ResultSet rs, Long transac, String rutaBase) throws SQLException {

		// Carga del objeto FERequet
		FECAERequest feReq = new FECAERequest();
		String errorParseo = "";
		// Cargo Cabezera.

		FECAECabRequest feCabecera = new FECAECabRequest();
		feCabecera.setCantReg(1);
		int tipoComp = 0;
		String letra = "";
		try {
			tipoComp = rs.getInt("TipoComprob");
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Tipo de Comprobante del campo 'TipoComprob'";
			e.printStackTrace();
		}

		try {
			letra = rs.getString("Letra");
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Tipo de Comprobante del campo 'TipoComprob'";
			e.printStackTrace();
		}

		int tipoCompAfip = getTipoComprobAfip(tipoComp, letra);

		feCabecera.setCbteTipo(tipoCompAfip);

		try {
			feCabecera.setPtoVta(Integer.parseInt(rs.getString("Prefijo")));
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'Prefijo'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'Prefijo'";
			e.printStackTrace();
		}

		feReq.setFeCabReq(feCabecera);

		// Cargo el detalle.
		FECAEDetRequest[] feDetalles = new FECAEDetRequest[1];
		FECAEDetRequest feDetalle = new FECAEDetRequest();
		try {
			feDetalle.setCbteDesde(Long.parseLong(rs.getString("NrComprob")));
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener el Numero del campo 'NrComprob'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Numero del campo 'NrComprob'";
			e.printStackTrace();
		}

		feDetalle.setCbteHasta(feDetalle.getCbteDesde());
		try {
			feDetalle.setCbteFch(DateUtil.getCanonicalFech(rs.getDate("fecha")));
		} catch (Exception e) {
			errorParseo = "No se ha podido obtener la fecha del campo 'Fecha'";
			e.printStackTrace();
		}

		feDetalle.setConcepto(1);
		try {
			String doc = rs.getString("cuit");
			feDetalle.setDocNro(FormatUtil.formatCuit(doc));

			if (doc.substring(0, 2).equals("00")) {
				feDetalle.setDocTipo(96);
			} else {
				feDetalle.setDocTipo(80);
			}
		} catch (Exception e) {
			errorParseo = "No se ha podido obtener CUIT o el tipo de documento del campo 'cuit'";
			e.printStackTrace();
		}

		// Moneda Fija pedido por sk
		feDetalle.setMonId("PES");
		feDetalle.setMonCotiz(1d);

		// Armar Otros Tributos
		Double perIb = 0d;
		Double perInternos = 0d;
		Double perIva = 0d;
		Double perGan = 0d;
		Double perCargasSoc = 0d;
		Double totalTributo = 0d;
		List<Tributo> tributosList = new ArrayList<Tributo>();

		feDetalles[0] = feDetalle;
		feReq.setFeDetReq(feDetalles);

		int tipoIvaAgendado = 1;

		try {
			tipoIvaAgendado = rs.getInt("tipoIva");
		} catch (Exception e) {
			e.printStackTrace();
		}

		feReq = this.completeValoresFactura(transac, rutaBase, feReq, tipoIvaAgendado);

		try {
			perIb = rs.getDouble("retib");
			if (perIb > 0) {
				perIb = FormatUtil.redondearEn2(perIb);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				Tributo tributoIb = fm.generateTributo(feReq.getFeDetReq()[0].getImpNeto(), perIb, "",
						Short.parseShort("2"));
				totalTributo = totalTributo + perIb;
				tributosList.add(tributoIb);
			}

		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Ingresos brutos del campo 'retib'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Ingresos brutos del campo 'retib'";
			e.printStackTrace();
		}

		try {

			perInternos = rs.getDouble("internos");
			if (perInternos > 0) {
				perInternos = FormatUtil.redondearEn2(perInternos);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				Tributo tributoInternos = fm.generateTributo(feReq.getFeDetReq()[0].getImpNeto(), perInternos, "",
						Short.parseShort("1"));
				totalTributo = totalTributo + perInternos;
				tributosList.add(tributoInternos);
			}

		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Internos del campo 'internos'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Internos del campo 'internos'";
			e.printStackTrace();
		}

		try {
			perIva = rs.getDouble("retiva");
			if (perIva > 0) {
				perIva = FormatUtil.redondearEn2(perIva);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				Tributo tributoIb = fm.generateTributo(feReq.getFeDetReq()[0].getImpNeto(), perIva, "",
						Short.parseShort("1"));
				totalTributo = totalTributo + perIva;
				tributosList.add(tributoIb);
			}

		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Iva del campo 'retiva'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Iva del campo 'retiva'";
			e.printStackTrace();
		}

		try {
			perGan = rs.getDouble("retgan");
			if (perGan > 0) {
				perGan = FormatUtil.redondearEn2(perGan);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				Tributo tributoIb = fm.generateTributo(feReq.getFeDetReq()[0].getImpNeto(), perGan, "",
						Short.parseShort("1"));
				totalTributo = totalTributo + perGan;
				tributosList.add(tributoIb);
			}

		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Ganancias del campo 'retgan'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Ganancias del campo 'retgan'";
			e.printStackTrace();
		}

		try {
			perCargasSoc = rs.getDouble("RetCargasSoc");
			if (perCargasSoc > 0) {
				perCargasSoc = FormatUtil.redondearEn2(perCargasSoc);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				Tributo tributoIb = fm.generateTributo(feReq.getFeDetReq()[0].getImpNeto(), perCargasSoc, "",
						Short.parseShort("2"));
				totalTributo = totalTributo + perCargasSoc;
				tributosList.add(tributoIb);
			}

		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Cargas Sociales del campo 'RetCargasSoc'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Cargas Sociales del campo 'RetCargasSoc'";
			e.printStackTrace();
		}

		try {
			if (tributosList.size() > 0) {
				Tributo[] tributos = new Tributo[tributosList.size()];
				int i = 0;

				for (Tributo tributo : tributosList) {
					tributos[i] = tributo;
					i++;
				}
				feReq.getFeDetReq()[0].setTributos(tributos);

			}
		} catch (Exception e) {
			errorParseo = "Error al calcular las percepciones";
			e.printStackTrace();
		}

		Double impTotal = feReq.getFeDetReq()[0].getImpTotal();

		// totalTributo = (FormatUtil.redondearEn2(impTotal));

		// impTotal = (FormatUtil.redondearEn2(impTotal));

		feReq.getFeDetReq()[0].setImpTrib(FormatUtil.redondearEn2(totalTributo));

		feReq.getFeDetReq()[0].setImpTotal(FormatUtil.redondearEn2(totalTributo + impTotal));

		Double totalSk = rs.getDouble("total");

		try {
			Integer tipoCompAso = rs.getInt("TipoComprobAso");

			String letraAso = rs.getString("LetraAso");

			int tipoCompAfipAso = getTipoComprobAfip(tipoCompAso, letraAso);

			String nrComprobAso = rs.getString("NrComprobAso");

			String prefijoAso = rs.getString("PrefijoAso");

			if (tipoCompAfipAso != 0) {
				CbteAsoc cbteAsoc = new CbteAsoc();
				cbteAsoc.setTipo(tipoCompAfipAso);

				cbteAsoc.setPtoVta(Integer.parseInt(prefijoAso));

				cbteAsoc.setNro(Long.parseLong(nrComprobAso.replace("*", "")));

				CbteAsoc[] cbtesAsoc = new CbteAsoc[1];
				cbtesAsoc[0] = cbteAsoc;
				feReq.getFeDetReq()[0].setCbtesAsoc(cbtesAsoc);

				System.out.println("Tiene Comprobante Asociado: " + prefijoAso + " - " + nrComprobAso);
			}

		} catch (Exception e) {
			System.out.println("No tiene Comprobante Asociado");
		}

		try {
			letra = rs.getString("Letra");
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Tipo de Comprobante del campo 'TipoComprob'";
			e.printStackTrace();
		}

		feCabecera.setCbteTipo(tipoCompAfip);

		try {
			feCabecera.setPtoVta(Integer.parseInt(rs.getString("Prefijo")));
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'Prefijo'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'Prefijo'";
			e.printStackTrace();
		}

		System.out.println("Total Generador por SKS: " + totalSk + " TransacNr: " + transac);

		System.out.println("Total Generador por FEOL: " + (FormatUtil.redondearEn2(totalTributo + impTotal))
				+ " TransacNr: " + transac);

		// Pregunto si difieren por mas de 15 centavos.
		if (isMoreDiferent(totalSk, FormatUtil.redondearEn2(totalTributo + impTotal), 15.0d)) {
			errorParseo = "Existe una diferencia entre la AFIP y SkSoft verifique los valores del comprobante. Total SKSoft: "
					+ totalSk + ", Total AFIP: " + FormatUtil.redondearEn2(totalTributo + impTotal);

		}
		if (isMoreDiferent(totalSk, FormatUtil.redondearEn2(totalTributo + impTotal), 0.10d)) {
			feReq.setActualizoTotal(false);
		} else {
			feReq.setActualizoTotal(true);
		}

		feReq.setErrorFE(errorParseo);

		return feReq;

	}

	private int getTipoComprobAfip(int tipoComp, String letra) {
		int tipoCompAfip = 0;
		if (tipoComp == 1 && letra.trim().equals("A")) {
			tipoCompAfip = 1;
		}
		if (tipoComp == 1 && letra.trim().equals("B")) {
			tipoCompAfip = 6;
		}
		if (tipoComp == 2 && letra.trim().equals("A")) {
			tipoCompAfip = 3;
		}
		if (tipoComp == 2 && letra.trim().equals("B")) {
			tipoCompAfip = 8;
		}
		if (tipoComp == 7 && letra.trim().equals("A")) {
			tipoCompAfip = 2;
		}
		if (tipoComp == 7 && letra.trim().equals("B")) {
			tipoCompAfip = 7;
		}
		return tipoCompAfip;
	}

	public void updateBase(Long transacNr, String cae, String vencimiento, String rutaBase, String nrComprob)
			throws SQLException {

		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		String query = "update transac set CAE = '" + cae + "', FechaCAE =  '" + vencimiento + "', NrComprob =  '"
				+ nrComprob + "' where transacNr = " + transacNr;

		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.execute();
		pstmt.close();
		conn.close();

	}

	public static boolean isMoreDiferent(Double valor1, Double valor2, Double diferencia) {
		boolean result = true;
		Double dif = valor1 - valor2;
		if (dif < 0)
			dif = dif * -1;

		if (dif > diferencia) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public void updateBase(Long transacNr, String cae, String vencimiento, String rutaBase, String nrComprob,
			Double total, boolean actualizoTotal) throws SQLException {

		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);
		String query = "";

		if (actualizoTotal) {
			query = "update transac set CAE = '" + cae + "', FechaCAE =  '" + vencimiento + "', NrComprob =  '"
					+ nrComprob + "', total =  " + total + " where transacNr = " + transacNr;
		} else {
			query = "update transac set CAE = '" + cae + "', FechaCAE =  '" + vencimiento + "', NrComprob =  '"
					+ nrComprob + "' where transacNr = " + transacNr;

		}
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.execute();
		pstmt.close();
		conn.close();

	}

	public FECAERequest getFacturaExt(Long transacNr, String rutaBase) {

		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		FECAERequest fECAERequest = null;
		try {
			ResultSet rs;
			Statement stmt;
			String sql;

			/*
			 * sql =
			 * "SELECT Transac.TipoComprob, Transac.NrComprob, Transac.RetIb, Transac.RetIva,Transac.Total, Transac.RetGan, Transac.RetCargasSoc, "
			 * + " Transac.Prefijo, Gente.Cuit, Transac.Fecha, " +
			 * "Transac.TransacNr, Transac.Letra FROM Transac INNER JOIN Gente " +
			 * "ON Transac.GenteNr = Gente.GenteNr WHERE (((Transac.TransacNr)=" + transacNr
			 * + "))";
			 */
			sql = "SELECT Transac.TipoComprob, Transac.NrComprob, Transac.internos,Transac.RetIb, Transac.RetIva,Transac.Total, Transac.RetGan, Transac.RetCargasSoc, "
					+ " Transac.Prefijo, Gente.Cuit, Transac.Fecha, Gente.tipoIva, "
					+ "Transac.TransacNr, Transac.Letra, Transac1.NrComprob as NrComprobAso, Transac1.Prefijo as PrefijoAso, Transac1.TipoComprob as TipoComprobAso, Transac1.Letra as LetraAso FROM Transac INNER JOIN "
					+ rutaComun + ".Gente as Gente "
					+ "ON Transac.GenteNr = Gente.GenteNr LEFT JOIN  Transac as Transac1  ON Transac.TranFactCred = Transac1.TransacNr WHERE (((Transac.TransacNr)="
					+ transacNr + "))";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				fECAERequest = makeFECAERequest(rs, transacNr, rutaBase);
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return fECAERequest;
	}

	public String getTipoFactura(Long transacNr, String rutaBase) throws Exception {

		String result = "NA";

		Connection conn = getConnMDB(rutaBase);

		try {
			ResultSet rs;
			Statement stmt;
			String sql;

			sql = "SELECT Transac.TransacNr, Transac.Letra, Transac.TipoComprob "
					+ "FROM Transac WHERE (((Transac.TransacNr)=" + transacNr + "))";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int tipoComp = 0;
				String letra = "";
				try {
					tipoComp = rs.getInt("TipoComprob");
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try {
					letra = rs.getString("Letra");
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (tipoComp == 1 && letra.trim().equals("A")) {
					result = "AB";
				}
				if (tipoComp == 1 && letra.trim().equals("B")) {
					result = "AB";
				}
				if (tipoComp == 2 && letra.trim().equals("A")) {
					result = "AB";
				}
				if (tipoComp == 2 && letra.trim().equals("B")) {
					result = "AB";
				}
				if (tipoComp == 7 && letra.trim().equals("A")) {
					result = "AB";
				}
				if (tipoComp == 7 && letra.trim().equals("B")) {
					result = "AB";
				}
				if (letra.trim().equals("E")) {
					result = "E";
				}
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return result;
	}

	private FECAERequest completeValoresFactura(Long transacNr, String rutaBase, FECAERequest fECAERequest,
			int tipoIvaAgendado) {

		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		try {
			ResultSet rs;
			Statement stmt;
			String sql;

			if (useSQL) {
				sql = "SELECT Stock.IvaGravado, Items.Precio, Items.Cant1, Items.Bonif, Items.TransacNr, "
						+ "Gente.Cuit, Transac.Fecha, Transac.TipoComprob, Transac.NrComprob, "
						+ "Transac.Prefijo, Transac.Vencim1, Transac.Total, Impuestos.Alicuota "
						+ "FROM (Transac WITH (NOLOCK) INNER JOIN ((" + rutaArticulo
						+ ".Stock as Stock WITH (NOLOCK) INNER JOIN Items WITH (NOLOCK)  ON Stock.Clave = Items.Articulo) "
						+ "INNER JOIN " + rutaComun
						+ ".Gente as Gente WITH (NOLOCK) ON Items.GenteNr = Gente.GenteNr) ON (Gente.GenteNr = Transac.GenteNr) "
						+ "AND (Transac.TransacNr = Items.TransacNr)) INNER JOIN Impuestos ON Stock.IvaGravado = "
						+ "Impuestos.Nr WHERE (((Items.TransacNr)=" + transacNr + "))";
			} else {
				sql = "SELECT Stock.IvaGravado, Items.Precio, Items.Cant1, Items.Bonif,Items.TransacNr, "
						+ "Gente.Cuit, Transac.Fecha, Transac.TipoComprob, Transac.NrComprob, "
						+ "Transac.Prefijo, Transac.Vencim1, Transac.Total, Impuestos.Alicuota "
						+ "FROM (Transac INNER JOIN ((" + rutaArticulo
						+ ".Stock as Stock INNER JOIN Items ON Stock.Clave = Items.Articulo) " + "INNER JOIN "
						+ rutaComun
						+ ".Gente as Gente ON Items.GenteNr = Gente.GenteNr) ON (Gente.GenteNr = Transac.GenteNr) "
						+ "AND (Transac.TransacNr = Items.TransacNr)) INNER JOIN Impuestos ON Stock.IvaGravado = "
						+ "Impuestos.Nr WHERE (((Items.TransacNr)=" + transacNr + "))";
			}

			System.out.println(sql);

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			Double neto = 0d;
			Double iva0 = -1d;
			Double iva10 = 0d;
			Double iva21 = 0d;
			Double iva27 = 0d;
			Double baseImp0 = 0d;
			Double baseImp10 = 0d;
			Double baseImp21 = 0d;
			Double baseImp27 = 0d;
			Double totalIVA = 0d;
			Double total = 0d;
			while (rs.next()) {

				Double precio = rs.getDouble("precio");

				Double porDesc = rs.getDouble("bonif");

//				porDesc = FormatUtil.redondearEn1(porDesc);
				Double cantidad = rs.getDouble("cant1");
				if (cantidad == 0) {
					cantidad = 1d;
				}

				// Double bonif = FormatUtil.redondearEn4(porDesc / 100);

				Double bonif = (porDesc / 100);

				// totalUnit = (cantidad * precio) - ((cantidad * precio) * bonif)n
				// Double descuento = (precio * porDesc) /100;

				// System.out.println("(" + precio + "*" + porDesc +")" + "/" + 100 +" = " +
				// descuento);
				// descuento = FormatUtil.redondearEn2(descuento);
				Double bruto = (cantidad * precio);

				Double totalUnit = bruto - (bruto * bonif);
				// System.out.println("(" + precio + "-" + descuento +")" + "*" + cantidad+" = "
				// + totalUnit);
//				totalUnit = FormatUtil.redondearEn2(totalUnit);

				System.out.println("totalUnit: " + totalUnit);
				Double alicouta = 0d;
				if (tipoIvaAgendado == 3) {
					alicouta = 0d;
				} else {
					alicouta = rs.getDouble("Alicuota");
				}

				if (alicouta.equals(0d)) {
					iva0 = 0d;
					baseImp0 = baseImp0 + totalUnit;
				}
				if (alicouta.equals(21d)) {
					iva21 = iva21 + (totalUnit * 21d / 100);
					baseImp21 = baseImp21 + totalUnit;
				}
				if (alicouta.equals(10.5d)) {
					iva10 = iva10 + (totalUnit * 10.5d / 100);
					baseImp10 = baseImp10 + totalUnit;
				}
				if (alicouta.equals(27d)) {
					iva27 = iva27 + (totalUnit * 27d / 100);
					baseImp27 = baseImp27 + totalUnit;
				}
				neto = neto + totalUnit;

			}
			totalIVA = iva21 + iva10 + iva27;
			total = neto + iva21 + iva10 + iva27;

			// Redondeo
			neto = FormatUtil.redondearEn2(neto);
			iva10 = FormatUtil.redondearEn2(iva10);
			iva21 = FormatUtil.redondearEn2(iva21);
			iva27 = FormatUtil.redondearEn2(iva27);
			baseImp0 = FormatUtil.redondearEn2(baseImp0);
			baseImp10 = FormatUtil.redondearEn2(baseImp10);
			baseImp21 = FormatUtil.redondearEn2(baseImp21);
			baseImp27 = FormatUtil.redondearEn2(baseImp27);
			totalIVA = FormatUtil.redondearEn2(totalIVA);
			total = FormatUtil.redondearEn2(total);

			System.out.println("Total " + neto);
			System.out.println("Total IVA 21: " + iva21);
			System.out.println("Total IVA 10.5: " + iva10);
			System.out.println("Total Bruto:  " + (total));

			List<AlicIva> alicIvaList = new ArrayList<AlicIva>();

			if (iva0 == 0) {
				AlicIva alicIva0 = new AlicIva();
				alicIva0.setId(3);
				alicIva0.setBaseImp(baseImp0);
				alicIva0.setImporte(iva0);
				alicIvaList.add(alicIva0);
			}

			if (iva21 > 0) {
				AlicIva alicIva21 = new AlicIva();
				alicIva21.setId(5);
				alicIva21.setBaseImp(baseImp21);
				alicIva21.setImporte(iva21);
				alicIvaList.add(alicIva21);
			}
			if (iva10 > 0) {
				AlicIva alicIva10 = new AlicIva();
				alicIva10.setId(4);
				alicIva10.setBaseImp(baseImp10);
				alicIva10.setImporte(iva10);
				alicIvaList.add(alicIva10);
			}
			if (iva27 > 0) {
				AlicIva alicIva27 = new AlicIva();
				alicIva27.setId(6);
				alicIva27.setBaseImp(baseImp27);
				alicIva27.setImporte(iva27);
				alicIvaList.add(alicIva27);
			}
			AlicIva[] alicIvas = null;
			try {
				if (alicIvaList.size() > 0) {
					alicIvas = new AlicIva[alicIvaList.size()];
					int i = 0;

					for (AlicIva alicIva : alicIvaList) {
						alicIvas[i] = alicIva;
						i++;
					}

				}
			} catch (Exception e) {
				fECAERequest.setErrorFE("Error al calcular las percepciones");
				e.printStackTrace();
			}

			fECAERequest.getFeDetReq()[0].setIva(alicIvas);
			fECAERequest.getFeDetReq()[0].setImpNeto(neto);
			fECAERequest.getFeDetReq()[0].setImpTotal(total);
			fECAERequest.getFeDetReq()[0].setImpIVA(totalIVA);

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return fECAERequest;
	}

	public Usuario getUsuario(String cuit, String rutaBase) {

		Usuario usuario = null;
		return usuario;
	}

	public void deleteFactuAfip(String rutaBase) throws SQLException {
		Connection conn = getConnMDB(rutaBase);

		String query_delete = "delete from factuAfip";
		PreparedStatement ps_d = conn.prepareStatement(query_delete);
		ps_d.executeUpdate();
		ps_d.close();
		conn.close();

	}

	public void updateSetFacturacion(FECompConsultaResponse feResponse, String rutaBase) throws SQLException {

		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		String query = "insert into factuAfip (fecha, tipoComprob, PuntoVenta,NroComprob,ImporteTotal"
				+ ",ImporteNeto,ImporteIVA,TipoDoc,CUIT,CAE,VencimCae) values (?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(query);
		PreparedStatement ps = conn.prepareStatement(query);
		System.out.println(feResponse.getResultGet());
		try {
			DateUtil.composeCanonicalFech(feResponse.getResultGet().getCbteFch());
			ps.setDate(1, new Date(DateUtil.composeCanonicalFech(feResponse.getResultGet().getCbteFch()).getTime()));
		} catch (Exception e) {
			e.printStackTrace();

		}
		ps.setInt(2, feResponse.getResultGet().getCbteTipo());
		ps.setString(3, String.valueOf(feResponse.getResultGet().getPtoVta()));
		ps.setString(4, String.valueOf(feResponse.getResultGet().getCbteDesde()));
		ps.setDouble(5, feResponse.getResultGet().getImpTotal());
		ps.setString(6, String.valueOf(feResponse.getResultGet().getImpNeto()));
		ps.setDouble(7, feResponse.getResultGet().getImpIVA());
		ps.setString(8, String.valueOf(feResponse.getResultGet().getDocTipo()));
		ps.setString(9, String.valueOf(feResponse.getResultGet().getDocNro()));
		ps.setString(10, String.valueOf(feResponse.getResultGet().getCodAutorizacion()));
		ps.setString(11, String.valueOf(feResponse.getResultGet().getFchVto()));

		ps.executeUpdate();
		ps.close();
		conn.close();

	}

}
