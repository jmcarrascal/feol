package fexv1.dif.afip.gov.ar;

public class ServiceSoapProxyExpov1 implements fexv1.dif.afip.gov.ar.ServiceSoapExpov1 {
  private String _endpoint = null;
  private fexv1.dif.afip.gov.ar.ServiceSoapExpov1 serviceSoapExpov1 = null;
  
  public ServiceSoapProxyExpov1() {
    _initServiceSoapProxy();
  }
  
  public ServiceSoapProxyExpov1(String endpoint) {
    _endpoint = endpoint;
    _initServiceSoapProxy();
  }
  
  private void _initServiceSoapProxy() {
    try {
      serviceSoapExpov1 = (new fexv1.dif.afip.gov.ar.ServiceLocatorExpov1()).getServiceSoap();
      if (serviceSoapExpov1 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceSoapExpov1)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceSoapExpov1)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceSoapExpov1 != null)
      ((javax.xml.rpc.Stub)serviceSoapExpov1)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fexv1.dif.afip.gov.ar.ServiceSoapExpov1 getServiceSoap() {
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1;
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponseAuthorize FEXAuthorize(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth, fexv1.dif.afip.gov.ar.ClsFEXRequest cmp) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXAuthorize(auth, cmp);
  }
  
  public fexv1.dif.afip.gov.ar.FEXGetCMPResponse FEXGetCMP(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth, fexv1.dif.afip.gov.ar.ClsFEXGetCMP cmp) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetCMP(auth, cmp);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_Cbte_Tipo FEXGetPARAM_Cbte_Tipo(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_Cbte_Tipo(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_Tex FEXGetPARAM_Tipo_Expo(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_Tipo_Expo(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_Inc FEXGetPARAM_Incoterms(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_Incoterms(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_Idi FEXGetPARAM_Idiomas(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_Idiomas(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_Umed FEXGetPARAM_UMed(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_UMed(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_DST_pais FEXGetPARAM_DST_pais(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_DST_pais(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_DST_cuit FEXGetPARAM_DST_CUIT(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_DST_CUIT(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_Mon FEXGetPARAM_MON(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_MON(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponseLast_CMP FEXGetLast_CMP(fexv1.dif.afip.gov.ar.ClsFEX_LastCMP auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetLast_CMP(auth);
  }
  
  public fexv1.dif.afip.gov.ar.DummyResponse FEXDummy() throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXDummy();
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_Ctz FEXGetPARAM_Ctz(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth, java.lang.String mon_id) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_Ctz(auth, mon_id);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_LastID FEXGetLast_ID(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetLast_ID(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_PtoVenta FEXGetPARAM_PtoVenta(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXGetPARAM_PtoVenta(auth);
  }
  
  public fexv1.dif.afip.gov.ar.FEXResponse_CheckPermiso FEXCheck_Permiso(fexv1.dif.afip.gov.ar.ClsFEXAuthRequest auth, java.lang.String ID_Permiso, int dst_merc) throws java.rmi.RemoteException{
    if (serviceSoapExpov1 == null)
      _initServiceSoapProxy();
    return serviceSoapExpov1.FEXCheck_Permiso(auth, ID_Permiso, dst_merc);
  }
  
  
}