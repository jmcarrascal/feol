/**
 * FECAEResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FEV1.dif.afip.gov.ar;

public class FECAEResponse  implements java.io.Serializable {
    private FEV1.dif.afip.gov.ar.FECAECabResponse feCabResp;

    private FEV1.dif.afip.gov.ar.FECAEDetResponse[] feDetResp;

    private FEV1.dif.afip.gov.ar.Evt[] events;

    private FEV1.dif.afip.gov.ar.Err[] errors;
    
    private byte[] requestEnviado;
    
    

    public byte[] getRequestEnviado() {
		return requestEnviado;
	}

	public void setRequestEnviado(byte[] requestEnviado) {
		this.requestEnviado = requestEnviado;
	}

	public FECAEResponse() {
    }

    public FECAEResponse(
           FEV1.dif.afip.gov.ar.FECAECabResponse feCabResp,
           FEV1.dif.afip.gov.ar.FECAEDetResponse[] feDetResp,
           FEV1.dif.afip.gov.ar.Evt[] events,
           FEV1.dif.afip.gov.ar.Err[] errors) {
           this.feCabResp = feCabResp;
           this.feDetResp = feDetResp;
           this.events = events;
           this.errors = errors;
    }


    /**
     * Gets the feCabResp value for this FECAEResponse.
     * 
     * @return feCabResp
     */
    public FEV1.dif.afip.gov.ar.FECAECabResponse getFeCabResp() {
        return feCabResp;
    }


    /**
     * Sets the feCabResp value for this FECAEResponse.
     * 
     * @param feCabResp
     */
    public void setFeCabResp(FEV1.dif.afip.gov.ar.FECAECabResponse feCabResp) {
        this.feCabResp = feCabResp;
    }


    /**
     * Gets the feDetResp value for this FECAEResponse.
     * 
     * @return feDetResp
     */
    public FEV1.dif.afip.gov.ar.FECAEDetResponse[] getFeDetResp() {
        return feDetResp;
    }


    /**
     * Sets the feDetResp value for this FECAEResponse.
     * 
     * @param feDetResp
     */
    public void setFeDetResp(FEV1.dif.afip.gov.ar.FECAEDetResponse[] feDetResp) {
        this.feDetResp = feDetResp;
    }


    /**
     * Gets the events value for this FECAEResponse.
     * 
     * @return events
     */
    public FEV1.dif.afip.gov.ar.Evt[] getEvents() {
        return events;
    }


    /**
     * Sets the events value for this FECAEResponse.
     * 
     * @param events
     */
    public void setEvents(FEV1.dif.afip.gov.ar.Evt[] events) {
        this.events = events;
    }


    /**
     * Gets the errors value for this FECAEResponse.
     * 
     * @return errors
     */
    public FEV1.dif.afip.gov.ar.Err[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this FECAEResponse.
     * 
     * @param errors
     */
    public void setErrors(FEV1.dif.afip.gov.ar.Err[] errors) {
        this.errors = errors;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FECAEResponse)) return false;
        FECAEResponse other = (FECAEResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.feCabResp==null && other.getFeCabResp()==null) || 
             (this.feCabResp!=null &&
              this.feCabResp.equals(other.getFeCabResp()))) &&
            ((this.feDetResp==null && other.getFeDetResp()==null) || 
             (this.feDetResp!=null &&
              java.util.Arrays.equals(this.feDetResp, other.getFeDetResp()))) &&
            ((this.events==null && other.getEvents()==null) || 
             (this.events!=null &&
              java.util.Arrays.equals(this.events, other.getEvents()))) &&
            ((this.errors==null && other.getErrors()==null) || 
             (this.errors!=null &&
              java.util.Arrays.equals(this.errors, other.getErrors())));
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
        if (getFeCabResp() != null) {
            _hashCode += getFeCabResp().hashCode();
        }
        if (getFeDetResp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFeDetResp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFeDetResp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEvents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEvents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEvents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FECAEResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feCabResp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FeCabResp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAECabResponse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feDetResp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FeDetResp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEDetResponse"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "FECAEDetResponse"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("events");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Events"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Evt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Evt"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Errors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Err"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.FEV1/", "Err"));
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
