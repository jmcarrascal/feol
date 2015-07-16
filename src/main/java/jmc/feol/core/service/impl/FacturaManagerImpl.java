package jmc.feol.core.service.impl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import jmc.feol.core.dao.FacturaDAO;
import jmc.feol.core.model.Empresa;
import jmc.feol.core.model.Factura;
import jmc.feol.core.service.CredencialAfipManager;
import jmc.feol.core.service.EmpresaManager;
import jmc.feol.core.service.FacturaManager;
import jmc.feol.core.service.ParametrizacionManager;
import jmc.feol.util.Constants;
import jmc.feol.util.FileUtil;
import jmc.feol.util.FormatUtil;
import jmc.feol.util.exception.GenerationTimerException;
import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FEAuthRequest;
import FEV1.dif.afip.gov.ar.FECAEAGetResponse;
import FEV1.dif.afip.gov.ar.FECAEARequest;
import FEV1.dif.afip.gov.ar.FECAEAResponse;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.FECAEResponse;
import FEV1.dif.afip.gov.ar.FECompConsultaReq;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.FECotizacionResponse;
import FEV1.dif.afip.gov.ar.FERecuperaLastCbteResponse;
import FEV1.dif.afip.gov.ar.ServiceSoapProxy;
import FEV1.dif.afip.gov.ar.Tributo;
import FEV1.dif.afip.gov.ar.wmtx.AuthRequestType;
import FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteRequestType;
import FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType;
import FEV1.dif.afip.gov.ar.wmtx.ComprobanteType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultaComprobanteRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultaUltimoComprobanteAutorizadoRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoResponseType;
import FEV1.dif.afip.gov.ar.wmtx.MTXCAServicePortTypeProxy;
import FEV1.dif.afip.gov.ar.wmtx.OtroTributoType;
import fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa;
import fex.dif.afip.gov.ar.ClsFEXRequestDesa;
import fex.dif.afip.gov.ar.ClsFEX_LastCMPDesa;
import fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa;
import fex.dif.afip.gov.ar.FEXResponseLast_CMPDesa;
import fex.dif.afip.gov.ar.FEXResponse_LastIDDesa;
import fex.dif.afip.gov.ar.ServiceSoapProxyDesa;
import fexv1.dif.afip.gov.ar.ClsFEXAuthRequest;
import fexv1.dif.afip.gov.ar.ClsFEXErr;
import fexv1.dif.afip.gov.ar.ClsFEXGetCMP;
import fexv1.dif.afip.gov.ar.ClsFEXGetCMPR;
import fexv1.dif.afip.gov.ar.ClsFEXRequest;
import fexv1.dif.afip.gov.ar.ClsFEX_LastCMP;
import fexv1.dif.afip.gov.ar.FEXGetCMPResponse;
import fexv1.dif.afip.gov.ar.FEXResponseAuthorize;
import fexv1.dif.afip.gov.ar.FEXResponseLast_CMP;
import fexv1.dif.afip.gov.ar.FEXResponse_Ctz;
import fexv1.dif.afip.gov.ar.FEXResponse_LastID;
import fexv1.dif.afip.gov.ar.ServiceSoapProxyExpov1;


/**
 * Clase que implementa los servicios referentes a Temas
 *  
 * @author Juan Manuel Carrascal.
 */
public class FacturaManagerImpl implements FacturaManager {

	private CredencialAfipManager credencialAfipManager;
	private EmpresaManager empresaManager;
	private ParametrizacionManager parametrizacionManager;
	private FacturaDAO extendedFacturaDAO;
	
	
		
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

	public CredencialAfipManager getCredencialAfipManager() {
		return credencialAfipManager;
	}

	public void setCredencialAfipManager(
			CredencialAfipManager credencialAfipManager) {
		this.credencialAfipManager = credencialAfipManager;
	}


	public EmpresaManager getEmpresaManager() {
		return empresaManager;
	}

	public void setEmpresaManager(EmpresaManager empresaManager) {
		this.empresaManager = empresaManager;
	}

	private Empresa getCredencial(Empresa empresa) throws Exception {
		/*
		 * Validar si la credencial fue otrogada antes de la N horas sacado de
		 * parametrizacion
		 */
		//Empresa empresa = empresaManager.getByPrimaryKey(idEmpresa);

		long hours = 2l;
		//long hours = Long.parseLong(parametrizacionManager.getParametrizacionById(8l).getValue());
		if (empresa.getLastToken() != null) {
			if (FileUtil.getHoursCompareEntryToNow(empresa.getLastToken(),hours)) {				
				empresa.setToken(null);
				Empresa empresaResult = credencialAfipManager.getCredencial(empresa);
				empresa.setToken(empresaResult.getToken());
				empresa.setSignToken(empresaResult.getSignToken());
				if (empresaResult.getToken() != null) {
					empresa.setLastToken(new Timestamp(System.currentTimeMillis()));
					empresaManager.updateEmpresa(empresa);
				}
			} else {
				// empresa = empresaManager.getByPrimaryKey(idEmpresa);
			}
		} else {
			CredencialAfipManager credencialAfipManager = new CredencialAfipManagerImpl();
			Empresa empresaResult = credencialAfipManager.getCredencial(empresa);			
			if (empresaResult.getToken() != null) {
				empresa.setLastToken(new Timestamp(System.currentTimeMillis()));
				
				empresaManager.updateEmpresa(empresa);
			}
		}

		return empresa;
	}

	
	private Long getLastRequestE(ClsFEXAuthRequestDesa auth, Empresa empresa){
		Long idRequest = 0l;
		ServiceSoapProxyDesa service = new ServiceSoapProxyDesa(empresa.getUrlWebService(),"");
		FEXResponse_LastIDDesa fEXResponse_LastIDDesa = new FEXResponse_LastIDDesa();
		
		try {
			fEXResponse_LastIDDesa = service.FEXGetLast_ID(auth);
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		try{
			
		
		System.out.println("Repuesta al pedido de ultimo Reuqest " + fEXResponse_LastIDDesa.getFEXResultGet().getId());
		
		System.out.println("Errores " + fEXResponse_LastIDDesa.getFEXErr().getErrMsg());
		
		System.out.println("Errores " + fEXResponse_LastIDDesa.getFEXErr().getErrCode());
		
		idRequest = fEXResponse_LastIDDesa.getFEXResultGet().getId();
		
		idRequest++;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return idRequest;
		
		
	}
	
	private Long getLastRequestExpov1(ClsFEXAuthRequest auth, Empresa empresa){
		Long idRequest = 0l;
		ServiceSoapProxyExpov1 service = new ServiceSoapProxyExpov1(empresa.getUrlWebService());
		FEXResponse_LastID fEXResponse_LastID = new FEXResponse_LastID();
		
		try {
			fEXResponse_LastID = service.FEXGetLast_ID(auth);
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		try{
			
		
		System.out.println("EXPOV1 : Repuesta al pedido de ultimo Reuqest " + fEXResponse_LastID.getFEXResultGet().getId());
		
		System.out.println("EXPOV1 : Errores " + fEXResponse_LastID.getFEXErr().getErrMsg());
		
		System.out.println("EXPOV1 : Errores " + fEXResponse_LastID.getFEXErr().getErrCode());
		
		idRequest = fEXResponse_LastID.getFEXResultGet().getId();
		
		idRequest++;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return idRequest;
		
		
	}
	
	public Long getLastNroFacturaByPyC(int prefijoInt, int cbteTipoInt, Empresa empresa) throws Exception{

		ServiceSoapProxy service = new ServiceSoapProxy(empresa.getUrlWebService());
		FEAuthRequest feAuth = new FEAuthRequest();
		Long idFactura = 0l;
		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}

		feAuth.setToken(empresa.getToken());
		feAuth.setSign(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));

		FERecuperaLastCbteResponse feLastResponse = new FERecuperaLastCbteResponse();
			feLastResponse = service.FECompUltimoAutorizado(feAuth,
					prefijoInt, cbteTipoInt);
			Err[] errores = feLastResponse.getErrors();
			if (errores != null) {
				for (Err err : errores) {
					System.out.println(err.getMsg());
				}
			}
			System.out.println(feLastResponse.getCbteNro());

		idFactura = new Long(feLastResponse.getCbteNro());
		

		return idFactura;
	}

	public Long getLastNroFactura(FECAERequest fECAERequest, Empresa empresa) throws Exception{

		ServiceSoapProxy service = new ServiceSoapProxy(empresa.getUrlWebService());
		FEAuthRequest feAuth = new FEAuthRequest();
		Long idFactura = 0l;
		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}

		feAuth.setToken(empresa.getToken());
		feAuth.setSign(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));

		FERecuperaLastCbteResponse feLastResponse = new FERecuperaLastCbteResponse();
			feLastResponse = service.FECompUltimoAutorizado(feAuth,
					fECAERequest.getFeCabReq().getPtoVta(), fECAERequest.getFeCabReq().getCbteTipo());
			Err[] errores = feLastResponse.getErrors();
			if (errores != null) {
				for (Err err : errores) {
					System.out.println(err.getMsg());
				}
			}
			System.out.println(feLastResponse.getCbteNro());

		idFactura = new Long(feLastResponse.getCbteNro());

		idFactura++;

		return idFactura;
	}
	

	public Long getLastNroFacturaMTX(ComprobanteType comprobanteType, Empresa empresa) throws Exception{

		Long idRequest = 0l;
		ConsultarUltimoComprobanteAutorizadoRequestType consultarUltimoComprobanteAutorizadoRequestType = new ConsultarUltimoComprobanteAutorizadoRequestType();
		
		MTXCAServicePortTypeProxy service = new MTXCAServicePortTypeProxy(empresa.getUrlWebService(),"");
		AuthRequestType feAuth = new AuthRequestType();
		try {
			//empresa = this.getCredencial(empresa.getIdEmpresa());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
						
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());
		
		feAuth.setCuitRepresentada(Long.parseLong(empresa.getCuit()));
		
		ConsultaUltimoComprobanteAutorizadoRequestType consultaUltimoComprobanteAutorizadoRequestType = new ConsultaUltimoComprobanteAutorizadoRequestType();
		
		consultaUltimoComprobanteAutorizadoRequestType.setCodigoTipoComprobante(comprobanteType.getCodigoTipoComprobante());
		
		consultaUltimoComprobanteAutorizadoRequestType.setNumeroPuntoVenta(comprobanteType.getNumeroPuntoVenta());
		
		consultarUltimoComprobanteAutorizadoRequestType.setAuthRequest(feAuth);
		
		consultarUltimoComprobanteAutorizadoRequestType.setConsultaUltimoComprobanteAutorizadoRequest(consultaUltimoComprobanteAutorizadoRequestType);
		
		ConsultarUltimoComprobanteAutorizadoResponseType consultarUltimoComprobanteAutorizadoResponseType = new ConsultarUltimoComprobanteAutorizadoResponseType(); 
				
		try {
			consultarUltimoComprobanteAutorizadoResponseType = service.consultarUltimoComprobanteAutorizado(consultarUltimoComprobanteAutorizadoRequestType);
		} catch (RemoteException e) {			
			e.printStackTrace();
		}		
		System.out.println(comprobanteType.getNumeroPuntoVenta());
		try{
			idRequest = consultarUltimoComprobanteAutorizadoResponseType.getNumeroComprobante(); 
		}catch(Exception e ){
			idRequest = 0l;
		}
		if (idRequest==null){
			idRequest = 0l;
		}
		idRequest++;
		
		return idRequest;
	}

	public FECAEResponse facturacionAFIP(FECAERequest fECAERequest, Empresa empresa, Long nroComp) throws Exception {

		ServiceSoapProxy service = new ServiceSoapProxy(empresa.getUrlWebService());
		FEAuthRequest feAuth = new FEAuthRequest();

		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}
		if (nroComp == null){
			if (parametrizacionManager.getParametrizacionByPrimaryKey(Constants.ID_TOMO_LAST_CMP).getValor().equals("true")){
				fECAERequest.getFeDetReq()[0].setCbteDesde(this.getLastNroFactura(fECAERequest, empresa));
			}
		}else{
			fECAERequest.getFeDetReq()[0].setCbteDesde(nroComp);
		}
		
		
		fECAERequest.getFeDetReq()[0].setCbteHasta(fECAERequest.getFeDetReq()[0].getCbteDesde());
		
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));		

		FECAEResponse feResponse = null;
		
		if (fECAERequest.getFeDetReq()[0].getDocNro() == 0 && fECAERequest.getFeDetReq()[0].getDocTipo() == 96)
			fECAERequest.getFeDetReq()[0].setDocNro(11111111);
		
		feResponse = service.FECAESolicitar(feAuth, fECAERequest);
		
		return feResponse;

	}
	
	public FECAEAResponse informarComprobCaeaAFIP(FECAEARequest fECAEARequest, Empresa empresa, Long nroComp) throws Exception {

		ServiceSoapProxy service = new ServiceSoapProxy(empresa.getUrlWebService());
		FEAuthRequest feAuth = new FEAuthRequest();

		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}
		
		//fECAEARequest.getFeDetReq()[0].setCbteDesde(nroComp);
				
		fECAEARequest.getFeDetReq()[0].setCbteHasta(fECAEARequest.getFeDetReq()[0].getCbteDesde());
		
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));		

		FECAEAResponse feResponse = null;
		
		if (fECAEARequest.getFeDetReq()[0].getDocNro() == 0 && fECAEARequest.getFeDetReq()[0].getDocTipo() == 96)
			fECAEARequest.getFeDetReq()[0].setDocNro(11111111);
		
		feResponse = service.FECAEARegInformativo(feAuth, fECAEARequest);
		
		return feResponse;

	}
	
	public AutorizarComprobanteResponseType facturacionAFIPMTX(ComprobanteType comprobanteType, Empresa empresa) throws Exception {

		MTXCAServicePortTypeProxy service = new MTXCAServicePortTypeProxy(empresa.getUrlWebService(),"");
		AuthRequestType feAuth = new AuthRequestType();
		AutorizarComprobanteRequestType autorizarComprobanteRequestType = new AutorizarComprobanteRequestType();
		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}

		feAuth.setToken(empresa.getToken());
		feAuth.setSign(empresa.getSignToken());
		
		feAuth.setCuitRepresentada(Long.parseLong(empresa.getCuit()));
		
		//LEVANTAR PARA PRODU
		
		String tomoUltNrFactura = parametrizacionManager.getParametrizacionByPrimaryKey(Constants.ID_TOMO_LAST_CMP).getValor();
		
		
		if (tomoUltNrFactura.equals("true")){
			comprobanteType.setNumeroComprobante(this.getLastNroFacturaMTX(comprobanteType, empresa));				
		}
		
		
		autorizarComprobanteRequestType.setAuthRequest(feAuth);
		autorizarComprobanteRequestType.setComprobanteCAERequest(comprobanteType);
		
		AutorizarComprobanteResponseType autorizarComprobanteResponseType = new AutorizarComprobanteResponseType();		
		try {									
			try{
				autorizarComprobanteResponseType = service.autorizarComprobante(autorizarComprobanteRequestType);
			}catch(Exception e){
				e.printStackTrace();				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return autorizarComprobanteResponseType;
	}

	public FECotizacionResponse getCotizacion(String monId, Empresa empresa) throws Exception {

		ServiceSoapProxy service = new ServiceSoapProxy(empresa.getUrlWebService());
		
		FEAuthRequest feAuth = new FEAuthRequest();

		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}
		
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));				
		
		FECotizacionResponse cotizacionResponse = null; 
		
		cotizacionResponse = service.FEParamGetCotizacion(feAuth, monId);
		
		return cotizacionResponse;

	}

	public FEXResponse_Ctz getCotizacionExpo(String monId, Empresa empresa) throws Exception {

		ServiceSoapProxyExpov1 service = new ServiceSoapProxyExpov1(empresa.getUrlWebService());
		
		ClsFEXAuthRequest feAuth = new ClsFEXAuthRequest();

		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}
		
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));				
		
		FEXResponse_Ctz cotizacionResponse = null; 
		
		cotizacionResponse = service.FEXGetPARAM_Ctz(feAuth, monId);
		
		return cotizacionResponse;

	}

	
	public byte[] getFactura(long cbteNro, int cbteTipo, int ptoVta, Empresa empresa) throws Exception {

		
		ServiceSoapProxy service = new ServiceSoapProxy(empresa.getUrlWebService());
		FEAuthRequest feAuth = new FEAuthRequest();

		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}
		
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());	
		
		feAuth.setCuit(Long.parseLong(empresa.getCuit()));
		
		FECompConsultaReq feCompConsReq = new FECompConsultaReq ();
		feCompConsReq.setCbteNro(cbteNro);
		feCompConsReq.setCbteTipo(cbteTipo);
		feCompConsReq.setPtoVta(ptoVta);
		try {
			FECompConsultaResponse fECompConsultaResponse   = service.FECompConsultar(feAuth, feCompConsReq);
			return fECompConsultaResponse.getXmlResponse();			
		} catch (RemoteException e) {			
			e.printStackTrace();
		}				
		return null;

	}

	public byte[] getFacturaExpo(long cbteNro, int cbteTipo, int ptoVta, Empresa empresa) throws Exception {

		
		ServiceSoapProxyExpov1 service = new ServiceSoapProxyExpov1(empresa.getUrlWebService());
		ClsFEXAuthRequest feAuth = new ClsFEXAuthRequest();

		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}
		
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());	
		
		feAuth.setCuit(Long.parseLong(empresa.getCuit()));
		
	    ClsFEXGetCMP feCompConsReq = new ClsFEXGetCMP ();
		feCompConsReq.setCbte_nro(cbteNro);
		feCompConsReq.setCbte_tipo(Short.parseShort(String.valueOf(cbteTipo)));
		feCompConsReq.setPunto_vta(Short.parseShort(String.valueOf(ptoVta)));
		
		try {
			FEXGetCMPResponse fECompConsultaResponse = service.FEXGetCMP(feAuth, feCompConsReq);
			ClsFEXGetCMPR fac = fECompConsultaResponse.getFEXResultGet(); 
			return FormatUtil.getFacturaXML(fac);			
		} catch (RemoteException e) {			
			e.printStackTrace();
		}				
		return null;

	}

	public String getEstadoAfipExpo(Empresa empresa) {

		ServiceSoapProxyExpov1 service = new ServiceSoapProxyExpov1(empresa.getUrlWebService());
		String result = "No hay Conectividad con AFIP";
		
		fexv1.dif.afip.gov.ar.DummyResponse d = null;
		try {
			d = service.FEXDummy();
			result = "Servidor AFIP: " + d.getAppServer() + ", " + "Base de Datos: " + d.getDbServer() + ", " + "Servidor de Autorizaci�n: " + d.getAuthServer();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public Long getLastCmpExpov1(ClsFEXAuthRequest auth, ClsFEXRequest cmp, Empresa empresa) throws Exception{
		Long idLastCmp = 0l;
		ServiceSoapProxyExpov1 service = new ServiceSoapProxyExpov1(empresa.getUrlWebService());
		FEXResponseLast_CMP fexResponseLastCMP = new FEXResponseLast_CMP();
		
		ClsFEX_LastCMP clsFEXLastCMP = new ClsFEX_LastCMP(auth.getToken(), auth.getSign(), auth.getCuit(), cmp.getPunto_vta(), Short.parseShort(String.valueOf(cmp.getCbte_nro())));
				
		fexResponseLastCMP = service.FEXGetLast_CMP(clsFEXLastCMP);
				
		try{
			System.out.println("EXPOV1 : Repuesta al pedido de ultimo cmp " + fexResponseLastCMP.getFEXResult_LastCMP().getCbte_nro());

			System.out.println("EXPOV1 : Errores " + fexResponseLastCMP.getFEXErr().getErrMsg());
			
			System.out.println("EXPOV1 : Errores " + fexResponseLastCMP.getFEXErr().getErrCode());

			idLastCmp = fexResponseLastCMP.getFEXResult_LastCMP().getCbte_nro();
			
			idLastCmp++;
			
		}catch(Exception e){
			e.printStackTrace();
			
			System.out.println("Errores " + fexResponseLastCMP.getFEXErr().getErrMsg());
			
			System.out.println("Errores " + fexResponseLastCMP.getFEXErr().getErrCode());			
		}
		
		return idLastCmp;
		
		
	}

	
	public Long getLastCmpE(ClsFEXAuthRequestDesa auth, ClsFEXRequestDesa cmp, Empresa empresa) throws Exception{
		Long idLastCmp = 0l;
		ServiceSoapProxyDesa service = new ServiceSoapProxyDesa(empresa.getUrlWebService(),"");
		FEXResponseLast_CMPDesa fexResponseLastCMP = new FEXResponseLast_CMPDesa();
		
		ClsFEX_LastCMPDesa clsFEXLastCMP = new ClsFEX_LastCMPDesa(auth.getToken(), auth.getSign(), auth.getCuit(), cmp.getPunto_vta(), cmp.getTipo_cbte());
				
		fexResponseLastCMP = service.FEXGetLast_CMP(clsFEXLastCMP);
				
		try{
			System.out.println("Repuesta al pedido de ultimo cmp " + fexResponseLastCMP.getFEXResult_LastCMP().getCbte_nro());

			System.out.println("Errores " + fexResponseLastCMP.getFEXErr().getErrMsg());
			
			System.out.println("Errores " + fexResponseLastCMP.getFEXErr().getErrCode());

			idLastCmp = fexResponseLastCMP.getFEXResult_LastCMP().getCbte_nro();
			
			idLastCmp++;
			
		}catch(Exception e){
			e.printStackTrace();
			
			System.out.println("Errores " + fexResponseLastCMP.getFEXErr().getErrMsg());
			
			System.out.println("Errores " + fexResponseLastCMP.getFEXErr().getErrCode());			
		}
		
		return idLastCmp;
		
		
	}
	public FEXResponseAuthorizeDesa facturacionEAFIP(ClsFEXRequestDesa cmp, Empresa empresa) throws Exception {

		ServiceSoapProxyDesa service = new ServiceSoapProxyDesa(empresa.getUrlWebService(),"");
		ClsFEXAuthRequestDesa feAuth = new ClsFEXAuthRequestDesa();			

		FEXResponseAuthorizeDesa fEXResponseAuthorizeDesa = new FEXResponseAuthorizeDesa();
		
		
		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}

		
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));	
		 
		cmp.setCbte_nro(getLastCmpE(feAuth, cmp, empresa));
		
		cmp.setId(getLastRequestE(feAuth,empresa));

		fEXResponseAuthorizeDesa = service.FEXAuthorize(feAuth, cmp);
		
		return fEXResponseAuthorizeDesa;

	}

	

	public Tributo generateTributo(Double baseImp, Double importe, String desc, short id){
		
		//importe = FormatUtil.redondearEn2(importe);
		
		Double alic = FormatUtil.redondearEn2(importe * 100 / baseImp);
		
		alic = FormatUtil.redondearEn2(alic);
		
		Tributo tributo = new Tributo();
		tributo.setAlic(alic);
		tributo.setBaseImp(baseImp);
		tributo.setDesc(desc);
		tributo.setId(id);
		tributo.setImporte(importe);
		System.out.println(tributo);
		return tributo;		
	}

	
	public OtroTributoType generateTributoMTX(BigDecimal baseImp, Double importe, String desc, short id){
		
		//importe = FormatUtil.redondearEn2(importe);
		
		Double alic = FormatUtil.redondearEn2(importe * 100 / baseImp.doubleValue());
		
		alic = FormatUtil.redondearEn2(alic);
		
		OtroTributoType tributo = new OtroTributoType();		
		tributo.setBaseImponible(baseImp);
		tributo.setDescripcion(desc);
		tributo.setCodigo(id);
		tributo.setImporte(BigDecimal.valueOf(importe));
		//System.out.println(tributo);
		return tributo;		
	}
	
	public Factura getFacturaByTransac(Long transacNr) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("numeroInterno", String.valueOf(transacNr));
		List<Factura> listFactura = extendedFacturaDAO.findByObjectCriteria(res);				
		if (listFactura.size() > 0)
			return listFactura.get(0);
		else
			return null;
	}

	public Factura getFacturaByTransac(String transacNr) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("numeroInterno", transacNr);
		List<Factura> listFactura = extendedFacturaDAO.findByObjectCriteria(res);				
		if (listFactura.size() > 0)
			return listFactura.get(0);
		else
			return null;
	}
	public void saveFactura(Factura factura) {
		extendedFacturaDAO.save(factura);		
	}

	
	public void updateFactura(Factura facturaUpdate) {
		facturaUpdate.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
		extendedFacturaDAO.update(facturaUpdate);
		
	}
	
	public List<Factura> getFacturasConErrorConn() {
		List<Factura> listFactura = extendedFacturaDAO.getFacturasConError();					
		return listFactura;
	}
	
	public Factura getByFactura(Factura facturaIn){
		return extendedFacturaDAO.getByFactura(facturaIn);
	}

	public Factura getByArchivo(String archivo){
		return extendedFacturaDAO.getByArchivo(archivo);
	}
	
	public Factura getFacturaById(Long idFactura) {
		
		return extendedFacturaDAO.getByPrimaryKey(idFactura);
	}

	
	public Factura getFacturaByTransacLetra(Long transacNr, String letra)
			throws Exception {
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("numeroInterno", String.valueOf(transacNr));
		res.put("letra", letra);
		List<Factura> listFactura = extendedFacturaDAO.findByObjectCriteria(res);				
		if (listFactura.size() > 0)
			return listFactura.get(0);
		else
			return null;
	}

	public ConsultarComprobanteResponseType getFacturaMTX(Long cbteNroLong,
			Integer cbteTipoInt, Integer prefijoInt, Empresa empresa) throws Exception{

		ConsultarComprobanteRequestType c = new ConsultarComprobanteRequestType();
		
		ConsultaComprobanteRequestType cc = new ConsultaComprobanteRequestType();
		
		cc.setCodigoTipoComprobante(Short.parseShort(String.valueOf(cbteTipoInt)));
		cc.setNumeroComprobante(cbteNroLong);
		cc.setNumeroPuntoVenta(Short.parseShort(String.valueOf(prefijoInt)));
		
		
		MTXCAServicePortTypeProxy service = new MTXCAServicePortTypeProxy(empresa.getUrlWebService(),"");
		AuthRequestType feAuth = new AuthRequestType();
		try {
			//empresa = this.getCredencial(empresa.getIdEmpresa());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
						
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());
		
		feAuth.setCuitRepresentada(Long.parseLong(empresa.getCuit()));

		c.setAuthRequest(feAuth);
		c.setConsultaComprobanteRequest(cc);
		
			
		Long idRequest = 0l;

		ConsultarComprobanteResponseType r = null;
		
		try {
			r = service.consultarComprobante(c);
		} catch (RemoteException e) {			
			e.printStackTrace();
		}		
		if (r.getArrayErrores() != null){
		for (CodigoDescripcionType co :r.getArrayErrores()){
			System.out.println(co.getDescripcion());
		}
		}
		
		return r;
	}

	
	
	
	public FECompConsultaResponse getComprobanteByPrimary(Long cbteNroLong,
			Integer cbteTipoInt, Integer prefijoInt, Empresa empresa) throws Exception {
		
		if (cbteNroLong != null){						
			ServiceSoapProxy service = new ServiceSoapProxy(empresa.getUrlWebService());
			FEAuthRequest feAuth = new FEAuthRequest();
	
			try {
				empresa = this.getCredencial(empresa);
			} catch (Exception e1) {		
				e1.printStackTrace();
				String msg = e1.getMessage();
				if (msg.indexOf("generationTime") != -1){
					throw new GenerationTimerException(1);
				}			
			}
			
			feAuth.setToken(empresa.getToken());
			
			feAuth.setSign(empresa.getSignToken());	
			
			feAuth.setCuit(Long.parseLong(empresa.getCuit()));
			
			FECompConsultaReq feCompConsReq = new FECompConsultaReq ();
			feCompConsReq.setCbteNro(cbteNroLong);
			feCompConsReq.setCbteTipo(cbteTipoInt);
			feCompConsReq.setPtoVta(prefijoInt);
			
			FECompConsultaResponse fECompConsultaResponse   = service.FECompConsultar(feAuth, feCompConsReq);
			return fECompConsultaResponse;
		}else{
			return null;
		}
		
	}

	public FEXResponseAuthorize facturacionEAFIPExpo(ClsFEXRequest feReq,
			Empresa empresa) throws Exception {
		ServiceSoapProxyExpov1 service = new ServiceSoapProxyExpov1(empresa.getUrlWebService());
		
		ClsFEXAuthRequest feAuth = new ClsFEXAuthRequest();

		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}
		
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));	
		
//		if (parametrizacionManager.getParametrizacionByPrimaryKey(Constants.ID_TOMO_LAST_CMP).getValor().equals("true")){
//			feReq.setCbte_nro(this.getLastCmpExpov1(feAuth,feReq, empresa));
//		}		
		
		FEXResponseAuthorize fEXResponseAuthorize = new FEXResponseAuthorize();
		
		feReq.setId(getLastRequestExpov1(feAuth,empresa));

		fEXResponseAuthorize = service.FEXAuthorize(feAuth, feReq);
						
		return fEXResponseAuthorize;
	}

	public Long getLastNroFacturaByPyCExpo(int prefijoInt, int cbteTipoInt,
			Empresa empresa) throws Exception {
		ServiceSoapProxyExpov1 service = new ServiceSoapProxyExpov1(empresa.getUrlWebService());
		ClsFEXAuthRequest feAuth = new ClsFEXAuthRequest();
		Long idFactura = 0l;
		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();
			String msg = e1.getMessage();
			if (msg.indexOf("generationTime") != -1){
				throw new GenerationTimerException(1);
			}			
		}

		feAuth.setToken(empresa.getToken());
		feAuth.setSign(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));
		
		ClsFEX_LastCMP lastCMP = new ClsFEX_LastCMP();
		
		lastCMP.setCbte_Tipo(Short.parseShort(String.valueOf(cbteTipoInt)));
		lastCMP.setPto_venta(Short.parseShort(String.valueOf(prefijoInt)));
		lastCMP.setCuit(Long.parseLong(empresa.getCuit()));
		lastCMP.setToken(empresa.getToken());
		lastCMP.setSign(empresa.getSignToken());
		

		FEXResponseLast_CMP feLastResponse = new FEXResponseLast_CMP();
		feLastResponse = service.FEXGetLast_CMP(lastCMP);
		ClsFEXErr err = feLastResponse.getFEXErr();
		
		System.out.println("FEOL EXPO: Error al obtener el ultimo numero de factura" + err.getErrMsg());	
		
		System.out.println("FEOL EXPO: Ultimo numero de factura" + feLastResponse.getFEXResult_LastCMP().getCbte_nro());

		idFactura = new Long(feLastResponse.getFEXResult_LastCMP().getCbte_nro());

		return idFactura;
	}


	public FECAEAGetResponse getCaea(String periodo, String quincena,
			Empresa empresa) {
		
		
		//ServiceSoapProxy service = new ServiceSoapProxy(empresa.getUrlWebService() + "?op=FECAEASolicitar");			
		ServiceSoapProxy service = new ServiceSoapProxy("http://wswhomo.afip.gov.ar/wsfev1/service.asmx?op=FECAEASolicitar");
		FEAuthRequest feAuth = new FEAuthRequest();

		try {
			empresa = this.getCredencial(empresa);
		} catch (Exception e1) {		
			e1.printStackTrace();			
					
		}
		
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());	
		
		feAuth.setCuit(Long.parseLong(empresa.getCuit()));
		Short orden = null;
		Integer periodoInt = null;
		try{
			periodoInt = Integer.parseInt(periodo);
			orden = Short.parseShort(quincena);
		}catch(Exception e){
			return null;
		}
		
		try {
			FECAEAGetResponse fECAEAResponse = service.FECAEASolicitar(feAuth,periodoInt,orden);			
			return fECAEAResponse;			
		} catch (RemoteException e) {			
			e.printStackTrace();
		}				
		return null;
	}
	
}
