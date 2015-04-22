/**
 * AutorizarComprobanteResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FEV1.dif.afip.gov.ar.wmtx;

public class AutorizarComprobanteResponseType  implements java.io.Serializable {
    private FEV1.dif.afip.gov.ar.wmtx.ResultadoSimpleType resultado;

    private FEV1.dif.afip.gov.ar.wmtx.ComprobanteCAEResponseType comprobanteResponse;

    private FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayObservaciones;

    private FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayErrores;

    private FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType evento;
    
    private byte[] requestEnviado;
    
    
    
    public byte[] getRequestEnviado() {
		return requestEnviado;
	}

	public void setRequestEnviado(byte[] requestEnviado) {
		this.requestEnviado = requestEnviado;
	}
	

	public AutorizarComprobanteResponseType() {
    }

    public AutorizarComprobanteResponseType(
           FEV1.dif.afip.gov.ar.wmtx.ResultadoSimpleType resultado,
           FEV1.dif.afip.gov.ar.wmtx.ComprobanteCAEResponseType comprobanteResponse,
           FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayObservaciones,
           FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayErrores,
           FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType evento) {
           this.resultado = resultado;
           this.comprobanteResponse = comprobanteResponse;
           this.arrayObservaciones = arrayObservaciones;
           this.arrayErrores = arrayErrores;
           this.evento = evento;
    }


    /**
     * Gets the resultado value for this AutorizarComprobanteResponseType.
     * 
     * @return resultado
     */
    public FEV1.dif.afip.gov.ar.wmtx.ResultadoSimpleType getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this AutorizarComprobanteResponseType.
     * 
     * @param resultado
     */
    public void setResultado(FEV1.dif.afip.gov.ar.wmtx.ResultadoSimpleType resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the comprobanteResponse value for this AutorizarComprobanteResponseType.
     * 
     * @return comprobanteResponse
     */
    public FEV1.dif.afip.gov.ar.wmtx.ComprobanteCAEResponseType getComprobanteResponse() {
        return comprobanteResponse;
    }


    /**
     * Sets the comprobanteResponse value for this AutorizarComprobanteResponseType.
     * 
     * @param comprobanteResponse
     */
    public void setComprobanteResponse(FEV1.dif.afip.gov.ar.wmtx.ComprobanteCAEResponseType comprobanteResponse) {
        this.comprobanteResponse = comprobanteResponse;
    }


    /**
     * Gets the arrayObservaciones value for this AutorizarComprobanteResponseType.
     * 
     * @return arrayObservaciones
     */
    public FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] getArrayObservaciones() {
        return arrayObservaciones;
    }


    /**
     * Sets the arrayObservaciones value for this AutorizarComprobanteResponseType.
     * 
     * @param arrayObservaciones
     */
    public void setArrayObservaciones(FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayObservaciones) {
        this.arrayObservaciones = arrayObservaciones;
    }


    /**
     * Gets the arrayErrores value for this AutorizarComprobanteResponseType.
     * 
     * @return arrayErrores
     */
    public FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] getArrayErrores() {
        return arrayErrores;
    }


    /**
     * Sets the arrayErrores value for this AutorizarComprobanteResponseType.
     * 
     * @param arrayErrores
     */
    public void setArrayErrores(FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayErrores) {
        this.arrayErrores = arrayErrores;
    }


    /**
     * Gets the evento value for this AutorizarComprobanteResponseType.
     * 
     * @return evento
     */
    public FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType getEvento() {
        return evento;
    }


    /**
     * Sets the evento value for this AutorizarComprobanteResponseType.
     * 
     * @param evento
     */
    public void setEvento(FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType evento) {
        this.evento = evento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutorizarComprobanteResponseType)) return false;
        AutorizarComprobanteResponseType other = (AutorizarComprobanteResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            ((this.comprobanteResponse==null && other.getComprobanteResponse()==null) || 
             (this.comprobanteResponse!=null &&
              this.comprobanteResponse.equals(other.getComprobanteResponse()))) &&
            ((this.arrayObservaciones==null && other.getArrayObservaciones()==null) || 
             (this.arrayObservaciones!=null &&
              java.util.Arrays.equals(this.arrayObservaciones, other.getArrayObservaciones()))) &&
            ((this.arrayErrores==null && other.getArrayErrores()==null) || 
             (this.arrayErrores!=null &&
              java.util.Arrays.equals(this.arrayErrores, other.getArrayErrores()))) &&
            ((this.evento==null && other.getEvento()==null) || 
             (this.evento!=null &&
              this.evento.equals(other.getEvento())));
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
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getComprobanteResponse() != null) {
            _hashCode += getComprobanteResponse().hashCode();
        }
        if (getArrayObservaciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayObservaciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayObservaciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getArrayErrores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayErrores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayErrores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEvento() != null) {
            _hashCode += getEvento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutorizarComprobanteResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarComprobanteResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ResultadoSimpleType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comprobanteResponse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comprobanteResponse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteCAEResponseType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayObservaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayObservaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayErrores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayErrores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "codigoDescripcion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("evento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "evento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType"));
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
