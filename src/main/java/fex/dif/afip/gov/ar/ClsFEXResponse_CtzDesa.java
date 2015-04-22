/**
 * ClsFEXResponse_Ctz.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public class ClsFEXResponse_CtzDesa  implements java.io.Serializable {
    private double mon_ctz;

    private java.lang.String mon_fecha;

    public ClsFEXResponse_CtzDesa() {
    }

    public ClsFEXResponse_CtzDesa(
           double mon_ctz,
           java.lang.String mon_fecha) {
           this.mon_ctz = mon_ctz;
           this.mon_fecha = mon_fecha;
    }


    /**
     * Gets the mon_ctz value for this ClsFEXResponse_Ctz.
     * 
     * @return mon_ctz
     */
    public double getMon_ctz() {
        return mon_ctz;
    }


    /**
     * Sets the mon_ctz value for this ClsFEXResponse_Ctz.
     * 
     * @param mon_ctz
     */
    public void setMon_ctz(double mon_ctz) {
        this.mon_ctz = mon_ctz;
    }


    /**
     * Gets the mon_fecha value for this ClsFEXResponse_Ctz.
     * 
     * @return mon_fecha
     */
    public java.lang.String getMon_fecha() {
        return mon_fecha;
    }


    /**
     * Sets the mon_fecha value for this ClsFEXResponse_Ctz.
     * 
     * @param mon_fecha
     */
    public void setMon_fecha(java.lang.String mon_fecha) {
        this.mon_fecha = mon_fecha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClsFEXResponse_CtzDesa)) return false;
        ClsFEXResponse_CtzDesa other = (ClsFEXResponse_CtzDesa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.mon_ctz == other.getMon_ctz() &&
            ((this.mon_fecha==null && other.getMon_fecha()==null) || 
             (this.mon_fecha!=null &&
              this.mon_fecha.equals(other.getMon_fecha())));
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
        _hashCode += new Double(getMon_ctz()).hashCode();
        if (getMon_fecha() != null) {
            _hashCode += getMon_fecha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClsFEXResponse_CtzDesa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Ctz"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mon_ctz");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Mon_ctz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mon_fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Mon_fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
