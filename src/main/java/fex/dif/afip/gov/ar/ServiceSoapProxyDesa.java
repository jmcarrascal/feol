package fex.dif.afip.gov.ar;

public class ServiceSoapProxyDesa implements fex.dif.afip.gov.ar.ServiceSoapDesa {
  private String _endpoint = null;
  private fex.dif.afip.gov.ar.ServiceSoapDesa serviceSoapDesa = null;
  
  public ServiceSoapProxyDesa() {
    _initServiceSoapProxy();
  }
  
  public ServiceSoapProxyDesa(String endpoint) {
    _endpoint = endpoint;
    _initServiceSoapProxy(endpoint);
  }
  
  public ServiceSoapProxyDesa(String urlWS,String nada) {	    
	    _initServiceSoapProxy(urlWS);
	  }
  private void _initServiceSoapProxy(String urlWS) {
    try {
      serviceSoapDesa = (new fex.dif.afip.gov.ar.ServiceLocatorDesa(urlWS)).getServiceSoap();
      if (serviceSoapDesa != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceSoapDesa)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceSoapDesa)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  private void _initServiceSoapProxy() {
	    try {
	      serviceSoapDesa = (new fex.dif.afip.gov.ar.ServiceLocatorDesa()).getServiceSoap();
	      if (serviceSoapDesa != null) {
	        if (_endpoint != null)
	          ((javax.xml.rpc.Stub)serviceSoapDesa)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	        else
	          _endpoint = (String)((javax.xml.rpc.Stub)serviceSoapDesa)._getProperty("javax.xml.rpc.service.endpoint.address");
	      }
	      
	    }
	    catch (javax.xml.rpc.ServiceException serviceException) {}
	  }
	 
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceSoapDesa != null)
      ((javax.xml.rpc.Stub)serviceSoapDesa)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fex.dif.afip.gov.ar.ServiceSoapDesa getServiceSoap() {
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa;
  }
  
  public fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa FEXAuthorize(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, fex.dif.afip.gov.ar.ClsFEXRequestDesa cmp) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXAuthorize(auth, cmp);
  }
  
  public fex.dif.afip.gov.ar.FEXGetCMPResponseDesa FEXGetCMP(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, fex.dif.afip.gov.ar.ClsFEXGetCMPDesa cmp) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetCMP(auth, cmp);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_Tipo_CbteDesa FEXGetPARAM_Tipo_Cbte(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_Tipo_Cbte(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_TexDesa FEXGetPARAM_Tipo_Expo(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_Tipo_Expo(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_IncDesa FEXGetPARAM_Incoterms(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_Incoterms(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_IdiDesa FEXGetPARAM_Idiomas(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_Idiomas(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_UmedDesa FEXGetPARAM_UMed(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_UMed(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_DST_paisDesa FEXGetPARAM_DST_pais(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_DST_pais(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_DST_cuitDesa FEXGetPARAM_DST_CUIT(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_DST_CUIT(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_MonDesa FEXGetPARAM_MON(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_MON(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponseLast_CMPDesa FEXGetLast_CMP(fex.dif.afip.gov.ar.ClsFEX_LastCMPDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetLast_CMP(auth);
  }
  
  public fex.dif.afip.gov.ar.DummyResponseDesa FEXDummy() throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXDummy();
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_CtzDesa FEXGetPARAM_Ctz(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, java.lang.String mon_id) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_Ctz(auth, mon_id);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_LastIDDesa FEXGetLast_ID(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetLast_ID(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_PtoVentaDesa FEXGetPARAM_PtoVenta(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXGetPARAM_PtoVenta(auth);
  }
  
  public fex.dif.afip.gov.ar.FEXResponse_CheckPermisoDesa FEXCheck_Permiso(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, java.lang.String ID_Permiso, int dst_merc) throws java.rmi.RemoteException{
    if (serviceSoapDesa == null)
      _initServiceSoapProxy();
    return serviceSoapDesa.FEXCheck_Permiso(auth, ID_Permiso, dst_merc);
  }
  
  
}