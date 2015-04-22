/**
 * MTXCAServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FEV1.dif.afip.gov.ar.wmtx;

public interface MTXCAServicePortType extends java.rmi.Remote {
    public FEV1.dif.afip.gov.ar.wmtx.DummyResponseType dummy() throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType autorizarComprobante(FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEAResponseType solicitarCAEA(FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEAResponseType informarComprobanteCAEA(FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoResponseType consultarUltimoComprobanteAutorizado(FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType consultarComprobante(FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteResponseType consultarTiposComprobante(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoResponseType consultarTiposDocumento(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVAResponseType consultarAlicuotasIVA(FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVAResponseType consultarCondicionesIVA(FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasResponseType consultarMonedas(FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaResponseType consultarCotizacionMoneda(FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaResponseType consultarUnidadesMedida(FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoResponseType consultarTiposTributo(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType consultarPuntosVenta(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType consultarPuntosVentaCAE(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAERequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType consultarPuntosVentaCAEA(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoResponseType informarCAEANoUtilizado(FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaResponseType informarCAEANoUtilizadoPtoVta(FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosResponseType consultarPtosVtaCAEANoInformados(FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAResponseType consultarCAEA(FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
    public FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasResponseType consultarCAEAEntreFechas(FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType;
}
