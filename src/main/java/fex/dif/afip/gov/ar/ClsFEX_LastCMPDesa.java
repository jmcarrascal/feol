/**
 * ClsFEX_LastCMP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public class ClsFEX_LastCMPDesa  implements java.io.Serializable {
    private java.lang.String token;

    private java.lang.String sign;

    private long cuit;

    private short pto_venta;

    private short tipo_cbte;

    public ClsFEX_LastCMPDesa() {
    }

    public ClsFEX_LastCMPDesa(
           java.lang.String token,
           java.lang.String sign,
           long cuit,
           short pto_venta,
           short tipo_cbte) {
           this.token = token;
           this.sign = sign;
           this.cuit = cuit;
           this.pto_venta = pto_venta;
           this.tipo_cbte = tipo_cbte;
    }


    /**
     * Gets the token value for this ClsFEX_LastCMP.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this ClsFEX_LastCMP.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the sign value for this ClsFEX_LastCMP.
     * 
     * @return sign
     */
    public java.lang.String getSign() {
        return sign;
    }


    /**
     * Sets the sign value for this ClsFEX_LastCMP.
     * 
     * @param sign
     */
    public void setSign(java.lang.String sign) {
        this.sign = sign;
    }


    /**
     * Gets the cuit value for this ClsFEX_LastCMP.
     * 
     * @return cuit
     */
    public long getCuit() {
        return cuit;
    }


    /**
     * Sets the cuit value for this ClsFEX_LastCMP.
     * 
     * @param cuit
     */
    public void setCuit(long cuit) {
        this.cuit = cuit;
    }


    /**
     * Gets the pto_venta value for this ClsFEX_LastCMP.
     * 
     * @return pto_venta
     */
    public short getPto_venta() {
        return pto_venta;
    }


    /**
     * Sets the pto_venta value for this ClsFEX_LastCMP.
     * 
     * @param pto_venta
     */
    public void setPto_venta(short pto_venta) {
        this.pto_venta = pto_venta;
    }


    /**
     * Gets the tipo_cbte value for this ClsFEX_LastCMP.
     * 
     * @return tipo_cbte
     */
    public short getTipo_cbte() {
        return tipo_cbte;
    }


    /**
     * Sets the tipo_cbte value for this ClsFEX_LastCMP.
     * 
     * @param tipo_cbte
     */
    public void setTipo_cbte(short tipo_cbte) {
        this.tipo_cbte = tipo_cbte;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClsFEX_LastCMPDesa)) return false;
        ClsFEX_LastCMPDesa other = (ClsFEX_LastCMPDesa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.token==null && other.getToken()==null) || 
             (this.token!=null &&
              this.token.equals(other.getToken()))) &&
            ((this.sign==null && other.getSign()==null) || 
             (this.sign!=null &&
              this.sign.equals(other.getSign()))) &&
            this.cuit == other.getCuit() &&
            this.pto_venta == other.getPto_venta() &&
            this.tipo_cbte == other.getTipo_cbte();
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
        if (getToken() != null) {
            _hashCode += getToken().hashCode();
        }
        if (getSign() != null) {
            _hashCode += getSign().hashCode();
        }
        _hashCode += new Long(getCuit()).hashCode();
        _hashCode += getPto_venta();
        _hashCode += getTipo_cbte();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClsFEX_LastCMPDesa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEX_LastCMP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("token");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Token"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sign");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Sign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Cuit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pto_venta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Pto_venta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo_cbte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Tipo_cbte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
