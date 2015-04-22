/**
 * FEXResponseAuthorize.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public class FEXResponseAuthorizeDesa  implements java.io.Serializable {
    private fex.dif.afip.gov.ar.ClsFEXOutAuthorizeDesa FEXResultAuth;

    private fex.dif.afip.gov.ar.ClsFEXErrDesa FEXErr;

    private fex.dif.afip.gov.ar.ClsFEXEventsDesa FEXEvents;
    
    private byte[] requestEnviado;
    
    

    public byte[] getRequestEnviado() {
		return requestEnviado;
	}

	public void setRequestEnviado(byte[] requestEnviado) {
		this.requestEnviado = requestEnviado;
	}

	public FEXResponseAuthorizeDesa() {
    }

    public FEXResponseAuthorizeDesa(
           fex.dif.afip.gov.ar.ClsFEXOutAuthorizeDesa FEXResultAuth,
           fex.dif.afip.gov.ar.ClsFEXErrDesa FEXErr,
           fex.dif.afip.gov.ar.ClsFEXEventsDesa FEXEvents) {
           this.FEXResultAuth = FEXResultAuth;
           this.FEXErr = FEXErr;
           this.FEXEvents = FEXEvents;
    }


    /**
     * Gets the FEXResultAuth value for this FEXResponseAuthorize.
     * 
     * @return FEXResultAuth
     */
    public fex.dif.afip.gov.ar.ClsFEXOutAuthorizeDesa getFEXResultAuth() {
        return FEXResultAuth;
    }


    /**
     * Sets the FEXResultAuth value for this FEXResponseAuthorize.
     * 
     * @param FEXResultAuth
     */
    public void setFEXResultAuth(fex.dif.afip.gov.ar.ClsFEXOutAuthorizeDesa FEXResultAuth) {
        this.FEXResultAuth = FEXResultAuth;
    }


    /**
     * Gets the FEXErr value for this FEXResponseAuthorize.
     * 
     * @return FEXErr
     */
    public fex.dif.afip.gov.ar.ClsFEXErrDesa getFEXErr() {
        return FEXErr;
    }


    /**
     * Sets the FEXErr value for this FEXResponseAuthorize.
     * 
     * @param FEXErr
     */
    public void setFEXErr(fex.dif.afip.gov.ar.ClsFEXErrDesa FEXErr) {
        this.FEXErr = FEXErr;
    }


    /**
     * Gets the FEXEvents value for this FEXResponseAuthorize.
     * 
     * @return FEXEvents
     */
    public fex.dif.afip.gov.ar.ClsFEXEventsDesa getFEXEvents() {
        return FEXEvents;
    }


    /**
     * Sets the FEXEvents value for this FEXResponseAuthorize.
     * 
     * @param FEXEvents
     */
    public void setFEXEvents(fex.dif.afip.gov.ar.ClsFEXEventsDesa FEXEvents) {
        this.FEXEvents = FEXEvents;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FEXResponseAuthorizeDesa)) return false;
        FEXResponseAuthorizeDesa other = (FEXResponseAuthorizeDesa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FEXResultAuth==null && other.getFEXResultAuth()==null) || 
             (this.FEXResultAuth!=null &&
              this.FEXResultAuth.equals(other.getFEXResultAuth()))) &&
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
        if (getFEXResultAuth() != null) {
            _hashCode += getFEXResultAuth().hashCode();
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
        new org.apache.axis.description.TypeDesc(FEXResponseAuthorizeDesa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponseAuthorize"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FEXResultAuth");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResultAuth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXOutAuthorize"));
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
