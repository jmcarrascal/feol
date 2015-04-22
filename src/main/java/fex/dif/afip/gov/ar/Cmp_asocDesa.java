/**
 * Cmp_asoc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public class Cmp_asocDesa  implements java.io.Serializable {
    private short CBte_tipo;

    private short cbte_punto_vta;

    private long cbte_nro;

    public Cmp_asocDesa() {
    }

    public Cmp_asocDesa(
           short CBte_tipo,
           short cbte_punto_vta,
           long cbte_nro) {
           this.CBte_tipo = CBte_tipo;
           this.cbte_punto_vta = cbte_punto_vta;
           this.cbte_nro = cbte_nro;
    }


    /**
     * Gets the CBte_tipo value for this Cmp_asoc.
     * 
     * @return CBte_tipo
     */
    public short getCBte_tipo() {
        return CBte_tipo;
    }


    /**
     * Sets the CBte_tipo value for this Cmp_asoc.
     * 
     * @param CBte_tipo
     */
    public void setCBte_tipo(short CBte_tipo) {
        this.CBte_tipo = CBte_tipo;
    }


    /**
     * Gets the cbte_punto_vta value for this Cmp_asoc.
     * 
     * @return cbte_punto_vta
     */
    public short getCbte_punto_vta() {
        return cbte_punto_vta;
    }


    /**
     * Sets the cbte_punto_vta value for this Cmp_asoc.
     * 
     * @param cbte_punto_vta
     */
    public void setCbte_punto_vta(short cbte_punto_vta) {
        this.cbte_punto_vta = cbte_punto_vta;
    }


    /**
     * Gets the cbte_nro value for this Cmp_asoc.
     * 
     * @return cbte_nro
     */
    public long getCbte_nro() {
        return cbte_nro;
    }


    /**
     * Sets the cbte_nro value for this Cmp_asoc.
     * 
     * @param cbte_nro
     */
    public void setCbte_nro(long cbte_nro) {
        this.cbte_nro = cbte_nro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cmp_asocDesa)) return false;
        Cmp_asocDesa other = (Cmp_asocDesa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.CBte_tipo == other.getCBte_tipo() &&
            this.cbte_punto_vta == other.getCbte_punto_vta() &&
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
        _hashCode += getCBte_tipo();
        _hashCode += getCbte_punto_vta();
        _hashCode += new Long(getCbte_nro()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Cmp_asocDesa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Cmp_asoc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CBte_tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "CBte_tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cbte_punto_vta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Cbte_punto_vta"));
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
