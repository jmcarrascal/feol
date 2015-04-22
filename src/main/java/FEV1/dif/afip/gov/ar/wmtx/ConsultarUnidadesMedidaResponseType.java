/**
 * ConsultarUnidadesMedidaResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FEV1.dif.afip.gov.ar.wmtx;

public class ConsultarUnidadesMedidaResponseType  implements java.io.Serializable {
    private FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayUnidadesMedida;

    private FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType evento;

    public ConsultarUnidadesMedidaResponseType() {
    }

    public ConsultarUnidadesMedidaResponseType(
           FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayUnidadesMedida,
           FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType evento) {
           this.arrayUnidadesMedida = arrayUnidadesMedida;
           this.evento = evento;
    }


    /**
     * Gets the arrayUnidadesMedida value for this ConsultarUnidadesMedidaResponseType.
     * 
     * @return arrayUnidadesMedida
     */
    public FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] getArrayUnidadesMedida() {
        return arrayUnidadesMedida;
    }


    /**
     * Sets the arrayUnidadesMedida value for this ConsultarUnidadesMedidaResponseType.
     * 
     * @param arrayUnidadesMedida
     */
    public void setArrayUnidadesMedida(FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayUnidadesMedida) {
        this.arrayUnidadesMedida = arrayUnidadesMedida;
    }


    /**
     * Gets the evento value for this ConsultarUnidadesMedidaResponseType.
     * 
     * @return evento
     */
    public FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType getEvento() {
        return evento;
    }


    /**
     * Sets the evento value for this ConsultarUnidadesMedidaResponseType.
     * 
     * @param evento
     */
    public void setEvento(FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType evento) {
        this.evento = evento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarUnidadesMedidaResponseType)) return false;
        ConsultarUnidadesMedidaResponseType other = (ConsultarUnidadesMedidaResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayUnidadesMedida==null && other.getArrayUnidadesMedida()==null) || 
             (this.arrayUnidadesMedida!=null &&
              java.util.Arrays.equals(this.arrayUnidadesMedida, other.getArrayUnidadesMedida()))) &&
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
        if (getArrayUnidadesMedida() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayUnidadesMedida());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayUnidadesMedida(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarUnidadesMedidaResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUnidadesMedidaResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayUnidadesMedida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayUnidadesMedida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType"));
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
