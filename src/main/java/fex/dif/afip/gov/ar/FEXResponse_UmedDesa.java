/**
 * FEXResponse_Umed.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public class FEXResponse_UmedDesa  implements java.io.Serializable {
    private fex.dif.afip.gov.ar.ClsFEXResponse_UMedDesa[] FEXResultGet;

    private fex.dif.afip.gov.ar.ClsFEXErrDesa FEXErr;

    private fex.dif.afip.gov.ar.ClsFEXEventsDesa FEXEvents;

    public FEXResponse_UmedDesa() {
    }

    public FEXResponse_UmedDesa(
           fex.dif.afip.gov.ar.ClsFEXResponse_UMedDesa[] FEXResultGet,
           fex.dif.afip.gov.ar.ClsFEXErrDesa FEXErr,
           fex.dif.afip.gov.ar.ClsFEXEventsDesa FEXEvents) {
           this.FEXResultGet = FEXResultGet;
           this.FEXErr = FEXErr;
           this.FEXEvents = FEXEvents;
    }


    /**
     * Gets the FEXResultGet value for this FEXResponse_Umed.
     * 
     * @return FEXResultGet
     */
    public fex.dif.afip.gov.ar.ClsFEXResponse_UMedDesa[] getFEXResultGet() {
        return FEXResultGet;
    }


    /**
     * Sets the FEXResultGet value for this FEXResponse_Umed.
     * 
     * @param FEXResultGet
     */
    public void setFEXResultGet(fex.dif.afip.gov.ar.ClsFEXResponse_UMedDesa[] FEXResultGet) {
        this.FEXResultGet = FEXResultGet;
    }


    /**
     * Gets the FEXErr value for this FEXResponse_Umed.
     * 
     * @return FEXErr
     */
    public fex.dif.afip.gov.ar.ClsFEXErrDesa getFEXErr() {
        return FEXErr;
    }


    /**
     * Sets the FEXErr value for this FEXResponse_Umed.
     * 
     * @param FEXErr
     */
    public void setFEXErr(fex.dif.afip.gov.ar.ClsFEXErrDesa FEXErr) {
        this.FEXErr = FEXErr;
    }


    /**
     * Gets the FEXEvents value for this FEXResponse_Umed.
     * 
     * @return FEXEvents
     */
    public fex.dif.afip.gov.ar.ClsFEXEventsDesa getFEXEvents() {
        return FEXEvents;
    }


    /**
     * Sets the FEXEvents value for this FEXResponse_Umed.
     * 
     * @param FEXEvents
     */
    public void setFEXEvents(fex.dif.afip.gov.ar.ClsFEXEventsDesa FEXEvents) {
        this.FEXEvents = FEXEvents;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FEXResponse_UmedDesa)) return false;
        FEXResponse_UmedDesa other = (FEXResponse_UmedDesa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FEXResultGet==null && other.getFEXResultGet()==null) || 
             (this.FEXResultGet!=null &&
              java.util.Arrays.equals(this.FEXResultGet, other.getFEXResultGet()))) &&
            ((this.FEXErr==null && other.getFEXErr()==null) || 
             (this.FEXErr!=null &&
              this.FEXErr.equals(other.getFEXErr()))) &&
            ((this.FEXEvents==null && other.getFEXEvents()==null) || 
             (this.FEXEvents!=null &&
              this.FEXEvents.equals(other.getFEXEvents())));
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
        if (getFEXResultGet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFEXResultGet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFEXResultGet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFEXErr() != null) {
            _hashCode += getFEXErr().hashCode();
        }
        if (getFEXEvents() != null) {
            _hashCode += getFEXEvents().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FEXResponse_UmedDesa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Umed"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FEXResultGet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResultGet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_UMed"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_UMed"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FEXErr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXErr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXErr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FEXEvents");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXEvents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXEvents"));
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
