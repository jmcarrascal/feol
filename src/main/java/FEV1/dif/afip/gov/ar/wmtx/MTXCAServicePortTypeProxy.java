package FEV1.dif.afip.gov.ar.wmtx;

public class MTXCAServicePortTypeProxy implements FEV1.dif.afip.gov.ar.wmtx.MTXCAServicePortType {
  private String _endpoint = null;
  private FEV1.dif.afip.gov.ar.wmtx.MTXCAServicePortType mTXCAServicePortType = null;
  
  public MTXCAServicePortTypeProxy() {
    _initMTXCAServicePortTypeProxy();
  }
  
  public MTXCAServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initMTXCAServicePortTypeProxy();
  }
  
  public MTXCAServicePortTypeProxy(String urlWS, String nada) {	    
	    _initMTXCAServicePortTypeProxy(urlWS);
  }
  
  private void _initMTXCAServicePortTypeProxy(String urlWS) {
    try {
      mTXCAServicePortType = (new FEV1.dif.afip.gov.ar.wmtx.MTXCAServiceLocator(urlWS)).getMTXCAServiceHttpSoap11Endpoint();
      if (mTXCAServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mTXCAServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mTXCAServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  private void _initMTXCAServicePortTypeProxy() {
	    try {
	      mTXCAServicePortType = (new FEV1.dif.afip.gov.ar.wmtx.MTXCAServiceLocator()).getMTXCAServiceHttpSoap11Endpoint();
	      if (mTXCAServicePortType != null) {
	        if (_endpoint != null)
	          ((javax.xml.rpc.Stub)mTXCAServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	        else
	          _endpoint = (String)((javax.xml.rpc.Stub)mTXCAServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
	      }
	      
	    }
	    catch (javax.xml.rpc.ServiceException serviceException) {}
	  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mTXCAServicePortType != null)
      ((javax.xml.rpc.Stub)mTXCAServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.MTXCAServicePortType getMTXCAServicePortType() {
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType;
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.DummyResponseType dummy() throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.dummy();
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType autorizarComprobante(FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.autorizarComprobante(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEAResponseType solicitarCAEA(FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.solicitarCAEA(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEAResponseType informarComprobanteCAEA(FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.informarComprobanteCAEA(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoResponseType consultarUltimoComprobanteAutorizado(FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarUltimoComprobanteAutorizado(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType consultarComprobante(FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarComprobante(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteResponseType consultarTiposComprobante(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarTiposComprobante(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoResponseType consultarTiposDocumento(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarTiposDocumento(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVAResponseType consultarAlicuotasIVA(FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarAlicuotasIVA(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVAResponseType consultarCondicionesIVA(FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarCondicionesIVA(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasResponseType consultarMonedas(FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarMonedas(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaResponseType consultarCotizacionMoneda(FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarCotizacionMoneda(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaResponseType consultarUnidadesMedida(FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarUnidadesMedida(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoResponseType consultarTiposTributo(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarTiposTributo(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType consultarPuntosVenta(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarPuntosVenta(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType consultarPuntosVentaCAE(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAERequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarPuntosVentaCAE(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType consultarPuntosVentaCAEA(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarPuntosVentaCAEA(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoResponseType informarCAEANoUtilizado(FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.informarCAEANoUtilizado(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaResponseType informarCAEANoUtilizadoPtoVta(FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.informarCAEANoUtilizadoPtoVta(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosResponseType consultarPtosVtaCAEANoInformados(FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarPtosVtaCAEANoInformados(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAResponseType consultarCAEA(FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarCAEA(parameters);
  }
  
  public FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasResponseType consultarCAEAEntreFechas(FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType{
    if (mTXCAServicePortType == null)
      _initMTXCAServicePortTypeProxy();
    return mTXCAServicePortType.consultarCAEAEntreFechas(parameters);
  }
  
  
}