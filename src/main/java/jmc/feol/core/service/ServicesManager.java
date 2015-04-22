package jmc.feol.core.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import jmc.feol.core.model.Caea;
import jmc.feol.core.model.Empresa;
import jmc.feol.core.model.Factura;
import jmc.feol.core.model.Patente;
import jmc.feol.core.model.Usuario;
import jmc.feol.core.model.cot.Viajes;

public interface ServicesManager {
	
	public String autorizoFactura(Long transacNr, String rutaBase, String rutaComun, String rutaArticulo);
	
	public Properties getPropertiesEmail();

	public void procesarFacturaError();
	
	public Properties getPropertiesEmail(String enviante);

	public void saveAdjuntoFactura(String transacNr, File adjunto) throws IOException;

	public void procesarFacturaByFiles();

	public Factura getFacturaById(Long idFactura);

	public String getCotizacionByMoneda(String moneda) throws Exception;

	public byte[] getFactura(long cbteNroLong, int cbteTipoInt, int prefijoInt);

	public long getLastNroCompr(int prefijoInt, int cbteTipoInt) throws Exception;

	public String gestionoFacturaABAS(String letra, Long transacNr) throws Exception;

	public void getImageCheque();

	public byte[] getByteImageCheques(String chequeNr, int parte);

	public void setChequeNr(String chequeNr, Integer parteInt);

	public void procesarFacturaByFilesExpov1();

	public String getCotizacionExpoByMoneda(String moneda);

	public long getLastNroComprExpo(int prefijoInt, int cbteTipoInt);

	public byte[] getFacturaExpo(long cbteNroLong, int cbteTipoInt,
			int prefijoInt);

	public String getEstadoAfipExpo();

	public List<Viajes> getViajesSinCot(Usuario usuario);

	public String autorizarViaje(int viajeNr, Usuario usuario, Patente patente);

	public byte[] getRemito(Integer viajeNr);

	public List<Patente> getPatenteAllOrden();

	public void deletePatente(Patente patente);

	public void addPatente(Patente patente);

	public void procesarFileFacturaError();	
	
	public void procesarFileFacturaError_v1();

	public String getFacturacionAFIP(String punto_vta,
			String rutaBaseFactuAfip, String cte_desde, String cte_hasta,
			String tipo_comprobante);

	public String getCaea(String periodo, String quincena, Empresa empresa);

	public List<Caea> getCAEAbyEmpresa(Empresa empresa);
	
}
