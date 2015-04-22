/**
 * ClsFEXGetCMP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public class ClsFEXGetCMPDesa  implements java.io.Serializable {
    private short tipo_cbte;

    private short punto_vta;

    private long cbte_nro;

    public ClsFEXGetCMPDesa() {
    }

    public ClsFEXGetCMPDesa(
           short tipo_cbte,
           short punto_vta,
           long cbte_nro) {
           this.tipo_cbte = tipo_cbte;
           this.punto_vta = punto_vta;
           this.cbte_nro = cbte_nro;
    }


    /**
     * Gets the tipo_cbte value for this ClsFEXGetCMP.
     * 
     * @return tipo_cbte
     */
    public short getTipo_cbte() {
        return tipo_cbte;
    }


    /**
     * Sets the tipo_cbte value for this ClsFEXGetCMP.
     * 
     * @param tipo_cbte
     */
    public void setTipo_cbte(short tipo_cbte) {
        this.tipo_cbte = tipo_cbte;
    }


    /**
     * Gets the punto_vta value for this ClsFEXGetCMP.
     * 
     * @return punto_vta
     */
    public short getPunto_vta() {
        return punto_vta;
    }


    /**
     * Sets the punto_vta value for this ClsFEXGetCMP.
     * 
     * @param punto_vta
     */
    public void setPunto_vta(short punto_vta) {
        this.punto_vta = punto_vta;
    }


    /**
     * Gets the cbte_nro value for this ClsFEXGetCMP.
     * 
     * @return cbte_nro
     */
    public long getCbte_nro() {
        return cbte_nro;
    }


    /**
     * Sets the cbte_nro value for this ClsFEXGetCMP.
     * 
     * @param cbte_nro
     */
    public void setCbte_nro(long cbte_nro) {
        this.cbte_nro = cbte_nro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClsFEXGetCMPDesa)) return false;
        ClsFEXGetCMPDesa other = (ClsFEXGetCMPDesa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.tipo_cbte == other.getTipo_cbte() &&
            this.punto_vta == other.getPunto_vta() &&
            this.cbte_nro == other.getCbte_nro();
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
        _hashCode += getTipo_cbte();
        _hashCode += getPunto_vta();
        _hashCode += new Long(getCbte_nro()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClsFEXGetCMPDesa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXGetCMP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo_cbte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Tipo_cbte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("punto_vta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Punto_vta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cbte_nro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Cbte_nro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
