/**
 * ConsultarPtosVtaCAEANoInformadosResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FEV1.dif.afip.gov.ar.wmtx;

public class ConsultarPtosVtaCAEANoInformadosResponseType  implements java.io.Serializable {
    private FEV1.dif.afip.gov.ar.wmtx.PuntoVentaType[] arrayPuntosVenta;

    private FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayErrores;

    private FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType evento;

    public ConsultarPtosVtaCAEANoInformadosResponseType() {
    }

    public ConsultarPtosVtaCAEANoInformadosResponseType(
           FEV1.dif.afip.gov.ar.wmtx.PuntoVentaType[] arrayPuntosVenta,
           FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayErrores,
           FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType evento) {
           this.arrayPuntosVenta = arrayPuntosVenta;
           this.arrayErrores = arrayErrores;
           this.evento = evento;
    }


    /**
     * Gets the arrayPuntosVenta value for this ConsultarPtosVtaCAEANoInformadosResponseType.
     * 
     * @return arrayPuntosVenta
     */
    public FEV1.dif.afip.gov.ar.wmtx.PuntoVentaType[] getArrayPuntosVenta() {
        return arrayPuntosVenta;
    }


    /**
     * Sets the arrayPuntosVenta value for this ConsultarPtosVtaCAEANoInformadosResponseType.
     * 
     * @param arrayPuntosVenta
     */
    public void setArrayPuntosVenta(FEV1.dif.afip.gov.ar.wmtx.PuntoVentaType[] arrayPuntosVenta) {
        this.arrayPuntosVenta = arrayPuntosVenta;
    }


    /**
     * Gets the arrayErrores value for this ConsultarPtosVtaCAEANoInformadosResponseType.
     * 
     * @return arrayErrores
     */
    public FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] getArrayErrores() {
        return arrayErrores;
    }


    /**
     * Sets the arrayErrores value for this ConsultarPtosVtaCAEANoInformadosResponseType.
     * 
     * @param arrayErrores
     */
    public void setArrayErrores(FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[] arrayErrores) {
        this.arrayErrores = arrayErrores;
    }


    /**
     * Gets the evento value for this ConsultarPtosVtaCAEANoInformadosResponseType.
     * 
     * @return evento
     */
    public FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType getEvento() {
        return evento;
    }


    /**
     * Sets the evento value for this ConsultarPtosVtaCAEANoInformadosResponseType.
     * 
     * @param evento
     */
    public void setEvento(FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType evento) {
        this.evento = evento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarPtosVtaCAEANoInformadosResponseType)) return false;
        ConsultarPtosVtaCAEANoInformadosResponseType other = (ConsultarPtosVtaCAEANoInformadosResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayPuntosVenta==null && other.getArrayPuntosVenta()==null) || 
             (this.arrayPuntosVenta!=null &&
              java.util.Arrays.equals(this.arrayPuntosVenta, other.getArrayPuntosVenta()))) &&
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
        if (getArrayPuntosVenta() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayPuntosVenta());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayPuntosVenta(), i);
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
        new org.apache.axis.description.TypeDesc(ConsultarPtosVtaCAEANoInformadosResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPtosVtaCAEANoInformadosResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayPuntosVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayPuntosVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "PuntoVentaType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "puntoVenta"));
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
