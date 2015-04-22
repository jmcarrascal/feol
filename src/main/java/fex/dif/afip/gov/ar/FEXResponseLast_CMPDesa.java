/**
 * FEXResponseLast_CMP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public class FEXResponseLast_CMPDesa  implements java.io.Serializable {
    private fex.dif.afip.gov.ar.ClsFEX_LastCMP_ResponseDesa FEXResult_LastCMP;

    private fex.dif.afip.gov.ar.ClsFEXErrDesa FEXErr;

    private fex.dif.afip.gov.ar.ClsFEXEventsDesa FEXEvents;

    public FEXResponseLast_CMPDesa() {
    }

    public FEXResponseLast_CMPDesa(
           fex.dif.afip.gov.ar.ClsFEX_LastCMP_ResponseDesa FEXResult_LastCMP,
           fex.dif.afip.gov.ar.ClsFEXErrDesa FEXErr,
           fex.dif.afip.gov.ar.ClsFEXEventsDesa FEXEvents) {
           this.FEXResult_LastCMP = FEXResult_LastCMP;
           this.FEXErr = FEXErr;
           this.FEXEvents = FEXEvents;
    }


    /**
     * Gets the FEXResult_LastCMP value for this FEXResponseLast_CMP.
     * 
     * @return FEXResult_LastCMP
     */
    public fex.dif.afip.gov.ar.ClsFEX_LastCMP_ResponseDesa getFEXResult_LastCMP() {
        return FEXResult_LastCMP;
    }


    /**
     * Sets the FEXResult_LastCMP value for this FEXResponseLast_CMP.
     * 
     * @param FEXResult_LastCMP
     */
    public void setFEXResult_LastCMP(fex.dif.afip.gov.ar.ClsFEX_LastCMP_ResponseDesa FEXResult_LastCMP) {
        this.FEXResult_LastCMP = FEXResult_LastCMP;
    }


    /**
     * Gets the FEXErr value for this FEXResponseLast_CMP.
     * 
     * @return FEXErr
     */
    public fex.dif.afip.gov.ar.ClsFEXErrDesa getFEXErr() {
        return FEXErr;
    }


    /**
     * Sets the FEXErr value for this FEXResponseLast_CMP.
     * 
     * @param FEXErr
     */
    public void setFEXErr(fex.dif.afip.gov.ar.ClsFEXErrDesa FEXErr) {
        this.FEXErr = FEXErr;
    }


    /**
     * Gets the FEXEvents value for this FEXResponseLast_CMP.
     * 
     * @return FEXEvents
     */
    public fex.dif.afip.gov.ar.ClsFEXEventsDesa getFEXEvents() {
        return FEXEvents;
    }


    /**
     * Sets the FEXEvents value for this FEXResponseLast_CMP.
     * 
     * @param FEXEvents
     */
    public void setFEXEvents(fex.dif.afip.gov.ar.ClsFEXEventsDesa FEXEvents) {
        this.FEXEvents = FEXEvents;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FEXResponseLast_CMPDesa)) return false;
        FEXResponseLast_CMPDesa other = (FEXResponseLast_CMPDesa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FEXResult_LastCMP==null && other.getFEXResult_LastCMP()==null) || 
             (this.FEXResult_LastCMP!=null &&
              this.FEXResult_LastCMP.equals(other.getFEXResult_LastCMP()))) &&
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
        if (getFEXResult_LastCMP() != null) {
            _hashCode += getFEXResult_LastCMP().hashCode();
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
        new org.apache.axis.description.TypeDesc(FEXResponseLast_CMPDesa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponseLast_CMP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FEXResult_LastCMP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResult_LastCMP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEX_LastCMP_Response"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
