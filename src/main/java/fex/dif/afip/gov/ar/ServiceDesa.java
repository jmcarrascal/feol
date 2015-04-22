/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public interface ServiceDesa extends javax.xml.rpc.Service {

/**
 * Web Service orientado  al  servicio  de autorizacion de comprobantes
 * de Exportacion electronicos
 */
    public java.lang.String getServiceSoapAddress();

    public fex.dif.afip.gov.ar.ServiceSoapDesa getServiceSoap() throws javax.xml.rpc.ServiceException;

    public fex.dif.afip.gov.ar.ServiceSoapDesa getServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getServiceSoap12Address();

    public fex.dif.afip.gov.ar.ServiceSoapDesa getServiceSoap12() throws javax.xml.rpc.ServiceException;

    public fex.dif.afip.gov.ar.ServiceSoapDesa getServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
