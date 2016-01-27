package jmc.feol.core.service;


import java.util.List;

import jmc.feol.core.model.Empresa;
import jmc.feol.core.model.Factura;
import FEV1.dif.afip.gov.ar.FECAEAGetResponse;
import FEV1.dif.afip.gov.ar.FECAEARequest;
import FEV1.dif.afip.gov.ar.FECAEAResponse;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.FECAEResponse;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.FECotizacionResponse;
import FEV1.dif.afip.gov.ar.Tributo;
import FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.ComprobanteType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType;
import fex.dif.afip.gov.ar.ClsFEXRequestDesa;
import fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa;
import fexv1.dif.afip.gov.ar.ClsFEXRequest;
import fexv1.dif.afip.gov.ar.FEXResponseAuthorize;
import fexv1.dif.afip.gov.ar.FEXResponse_Ctz;


/**
 * Interfaz de acceso a los servicios referentes a Temas
 * @author Juan Manuel Carrascal
 */
public interface FacturaManager {

	public Long getLastNroFactura(FECAERequest fECAERequest, Empresa empresa) throws Exception;
	
	public FECAEResponse facturacionAFIP(FECAERequest fECAERequest, Empresa empresa, Long nroComp) throws Exception;
	
	public Tributo generateTributo(Double baseImp, Double importe, String desc, short id);
	
	public FEXResponseAuthorizeDesa facturacionEAFIP(ClsFEXRequestDesa cmp, Empresa empresa) throws Exception;

	public Factura getFacturaByTransac(Long transacNr);

	public void saveFactura(Factura generateFacturaAB);

	public void updateFactura(Factura facturaUpdate);

	public List<Factura> getFacturasConErrorConn();
			
	public Factura getFacturaByTransac(String transacNr);
	
	public Factura getByFactura(Factura facturaIn);

	public Factura getFacturaById(Long idFactura);
	
	public FECotizacionResponse getCotizacion(String monId, Empresa empresa) throws Exception;
	
	public byte[] getFactura(long cbteNro, int cbteTipo, int ptoVta, Empresa empresa) throws Exception;
	
	public Long getLastNroFacturaByPyC(int prefijoInt, int cbteTipoInt, Empresa empresa) throws Exception;
	
	public Factura getByArchivo(String archivo);

	public Factura getFacturaByTransacLetra(Long transacNr, String letra)throws Exception;
	
	public AutorizarComprobanteResponseType facturacionAFIPMTX(ComprobanteType comprobanteType, Empresa empresa) throws Exception ;

	public FECompConsultaResponse getComprobanteByPrimary(Long cbteNroLong, Integer cbteTipoInt,
			Integer prefijoInt, Empresa empresa) throws Exception;

	public FEXResponseAuthorize facturacionEAFIPExpo(ClsFEXRequest feReq,
			Empresa empresa) throws Exception;
	
	public FEXResponse_Ctz getCotizacionExpo(String monId, Empresa empresa) throws Exception ;

	public Long getLastNroFacturaByPyCExpo(int prefijoInt, int cbteTipoInt,
			Empresa empresa) throws Exception ;

	public byte[] getFacturaExpo(long cbteNroLong, int cbteTipoInt,
			int prefijoInt, Empresa empresa) throws Exception;	

	public String getEstadoAfipExpo(Empresa empresa);
	
	public ConsultarComprobanteResponseType getFacturaMTX(Long cbteNroLong,
			Integer cbteTipoInt, Integer prefijoInt, Empresa empresa) throws Exception;

	public FECAEAGetResponse getCaea(String periodo, String quincena,
			Empresa empresa);
	public FECAEAResponse informarComprobCaeaAFIP(FECAEARequest fECAEARequest, Empresa empresa, Long nroComp) throws Exception ;
	
	public Long getLastNroFacturaMTX(ComprobanteType comprobanteType, Empresa empresa) throws Exception;
}
