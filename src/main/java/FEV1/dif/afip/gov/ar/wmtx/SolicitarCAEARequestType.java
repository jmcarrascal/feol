/**
 * SolicitarCAEARequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FEV1.dif.afip.gov.ar.wmtx;

public class SolicitarCAEARequestType  implements java.io.Serializable {
    private FEV1.dif.afip.gov.ar.wmtx.AuthRequestType authRequest;

    private FEV1.dif.afip.gov.ar.wmtx.SolicitudCAEAType solicitudCAEA;

    public SolicitarCAEARequestType() {
    }

    public SolicitarCAEARequestType(
           FEV1.dif.afip.gov.ar.wmtx.AuthRequestType authRequest,
           FEV1.dif.afip.gov.ar.wmtx.SolicitudCAEAType solicitudCAEA) {
           this.authRequest = authRequest;
           this.solicitudCAEA = solicitudCAEA;
    }


    /**
     * Gets the authRequest value for this SolicitarCAEARequestType.
     * 
     * @return authRequest
     */
    public FEV1.dif.afip.gov.ar.wmtx.AuthRequestType getAuthRequest() {
        return authRequest;
    }


    /**
     * Sets the authRequest value for this SolicitarCAEARequestType.
     * 
     * @param authRequest
     */
    public void setAuthRequest(FEV1.dif.afip.gov.ar.wmtx.AuthRequestType authRequest) {
        this.authRequest = authRequest;
    }


    /**
     * Gets the solicitudCAEA value for this SolicitarCAEARequestType.
     * 
     * @return solicitudCAEA
     */
    public FEV1.dif.afip.gov.ar.wmtx.SolicitudCAEAType getSolicitudCAEA() {
        return solicitudCAEA;
    }


    /**
     * Sets the solicitudCAEA value for this SolicitarCAEARequestType.
     * 
     * @param solicitudCAEA
     */
    public void setSolicitudCAEA(FEV1.dif.afip.gov.ar.wmtx.SolicitudCAEAType solicitudCAEA) {
        this.solicitudCAEA = solicitudCAEA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SolicitarCAEARequestType)) return false;
        SolicitarCAEARequestType other = (SolicitarCAEARequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authRequest==null && other.getAuthRequest()==null) || 
             (this.authRequest!=null &&
              this.authRequest.equals(other.getAuthRequest()))) &&
            ((this.solicitudCAEA==null && other.getSolicitudCAEA()==null) || 
             (this.solicitudCAEA!=null &&
              this.solicitudCAEA.equals(other.getSolicitudCAEA())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAuthRequest() != null) {
            _hashCode += getAuthRequest().hashCode();
        }
        if (getSolicitudCAEA() != null) {
            _hashCode += getSolicitudCAEA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SolicitarCAEARequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitarCAEARequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AuthRequestType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("solicitudCAEA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "solicitudCAEA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitudCAEAType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
