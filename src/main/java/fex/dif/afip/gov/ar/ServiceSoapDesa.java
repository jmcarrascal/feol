/**
 * ServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public interface ServiceSoapDesa extends java.rmi.Remote {

    /**
     * Autoriza un comprobante, devolviendo  su CAE correspondiente
     */
    public fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa FEXAuthorize(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, fex.dif.afip.gov.ar.ClsFEXRequestDesa cmp) throws java.rmi.RemoteException;

    /**
     * Recupera los datos completos de un comprobante ya autorizado
     */
    public fex.dif.afip.gov.ar.FEXGetCMPResponseDesa FEXGetCMP(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, fex.dif.afip.gov.ar.ClsFEXGetCMPDesa cmp) throws java.rmi.RemoteException;

    /**
     * Recupera el listado de los tipos de comprobante  y su codigo
     * utilizables en servicio de autorizacion
     */
    public fex.dif.afip.gov.ar.FEXResponse_Tipo_CbteDesa FEXGetPARAM_Tipo_Cbte(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Recupera el listado de los tipos de exportacion  y sus codigo
     * utilizables en servicio de autorizacion
     */
    public fex.dif.afip.gov.ar.FEXResponse_TexDesa FEXGetPARAM_Tipo_Expo(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Recupera el listado Incoterms  utilizables en servicio de autorizacion
     */
    public fex.dif.afip.gov.ar.FEXResponse_IncDesa FEXGetPARAM_Incoterms(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Recupera el listado de los idiomas  y sus codigos utilizables
     * en servicio de autorizacion
     */
    public fex.dif.afip.gov.ar.FEXResponse_IdiDesa FEXGetPARAM_Idiomas(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Recupera el listado de las unidades de medida  y su codigo
     * utilizables en servicio de autorizacion
     */
    public fex.dif.afip.gov.ar.FEXResponse_UmedDesa FEXGetPARAM_UMed(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Recupera el listado de paises
     */
    public fex.dif.afip.gov.ar.FEXResponse_DST_paisDesa FEXGetPARAM_DST_pais(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Recupera el listado de las cuits de los paises de destinacion
     */
    public fex.dif.afip.gov.ar.FEXResponse_DST_cuitDesa FEXGetPARAM_DST_CUIT(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Recupera el listado  de monedas y su codigo utilizables en
     * servicio de autorizacion
     */
    public fex.dif.afip.gov.ar.FEXResponse_MonDesa FEXGetPARAM_MON(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Recupera el ultimos comprobante autorizado
     */
    public fex.dif.afip.gov.ar.FEXResponseLast_CMPDesa FEXGetLast_CMP(fex.dif.afip.gov.ar.ClsFEX_LastCMPDesa auth) throws java.rmi.RemoteException;

    /**
     * Metodo dummy para verificacion de funcionamiento
     */
    public fex.dif.afip.gov.ar.DummyResponseDesa FEXDummy() throws java.rmi.RemoteException;

    /**
     * Recupera la cotizacion de la moneda consultada y su  fecha
     */
    public fex.dif.afip.gov.ar.FEXResponse_CtzDesa FEXGetPARAM_Ctz(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, java.lang.String mon_id) throws java.rmi.RemoteException;

    /**
     * Recupera el ultimo ID y su  fecha
     */
    public fex.dif.afip.gov.ar.FEXResponse_LastIDDesa FEXGetLast_ID(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Recupera el listado de los puntos de venta registrados para
     * Factura electronica de exportacion - WS y su estado
     */
    public fex.dif.afip.gov.ar.FEXResponse_PtoVentaDesa FEXGetPARAM_PtoVenta(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException;

    /**
     * Verifica la  existencia de la permiso/pais de destinación 
     * de embarque ingresado
     */
    public fex.dif.afip.gov.ar.FEXResponse_CheckPermisoDesa FEXCheck_Permiso(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, java.lang.String ID_Permiso, int dst_merc) throws java.rmi.RemoteException;
}
