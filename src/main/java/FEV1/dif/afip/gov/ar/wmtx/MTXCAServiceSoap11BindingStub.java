/**
 * MTXCAServiceSoap11BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FEV1.dif.afip.gov.ar.wmtx;

import java.io.ByteArrayOutputStream;

import org.apache.axis.MessageContext;
import org.apache.axis.utils.XMLUtils;

public class MTXCAServiceSoap11BindingStub extends org.apache.axis.client.Stub implements FEV1.dif.afip.gov.ar.wmtx.MTXCAServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[22];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("dummy");
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DummyResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.DummyResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "dummyResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("autorizarComprobante");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "autorizarComprobanteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarComprobanteRequestType"), FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarComprobanteResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "autorizarComprobanteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("solicitarCAEA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "solicitarCAEARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitarCAEARequestType"), FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitarCAEAResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "solicitarCAEAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informarComprobanteCAEA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarComprobanteCAEARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarComprobanteCAEARequestType"), FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarComprobanteCAEAResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarComprobanteCAEAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarUltimoComprobanteAutorizado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarUltimoComprobanteAutorizadoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUltimoComprobanteAutorizadoRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUltimoComprobanteAutorizadoResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarUltimoComprobanteAutorizadoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarComprobante");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarComprobanteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarComprobanteRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarComprobanteResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarComprobanteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposComprobante");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposComprobanteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposComprobanteRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposComprobanteResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposComprobanteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposDocumento");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposDocumentoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDocumentoRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDocumentoResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposDocumentoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarAlicuotasIVA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarAlicuotasIVARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarAlicuotasIVARequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarAlicuotasIVAResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarAlicuotasIVAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCondicionesIVA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCondicionesIVARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCondicionesIVARequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCondicionesIVAResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCondicionesIVAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarMonedas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarMonedasRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarMonedasRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarMonedasResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarMonedasResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCotizacionMoneda");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCotizacionMonedaRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCotizacionMonedaRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCotizacionMonedaResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCotizacionMonedaResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarUnidadesMedida");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarUnidadesMedidaRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUnidadesMedidaRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUnidadesMedidaResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarUnidadesMedidaResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarPuntosVenta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarPuntosVentaCAE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaCAERequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaCAERequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAERequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaCAEResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarPuntosVentaCAEA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaCAEARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaCAEARequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAEARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPuntosVentaCAEAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informarCAEANoUtilizado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarCAEANoUtilizadoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoRequestType"), FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarCAEANoUtilizadoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTiposTributo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposTributoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposTributoRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposTributoResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarTiposTributoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("informarCAEANoUtilizadoPtoVta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarCAEANoUtilizadoPtoVtaRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaRequestType"), FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "informarCAEANoUtilizadoPtoVtaResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCAEA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCAEARequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEARequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEARequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCAEAResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarPtosVtaCAEANoInformados");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPtosVtaCAEANoInformadosRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPtosVtaCAEANoInformadosRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPtosVtaCAEANoInformadosResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarPtosVtaCAEANoInformadosResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCAEAEntreFechas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCAEAEntreFechasRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAEntreFechasRequestType"), FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAEntreFechasResponseType"));
        oper.setReturnClass(FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "consultarCAEAEntreFechasResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "exceptionResponse"),
                      "ar.gov.afip.wsmtxca.service.impl.service.ExceptionResponseType",
                      new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType"), 
                      true
                     ));
        _operations[21] = oper;

    }

    public MTXCAServiceSoap11BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public MTXCAServiceSoap11BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public MTXCAServiceSoap11BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.CAEAResponseType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CAEAResponseType");
            qName2 = new javax.xml.namespace.QName("", "CAEAResponse");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayCodigosDescripcionesStringType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionStringType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionStringType");
            qName2 = new javax.xml.namespace.QName("", "codigoDescripcion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayCodigosDescripcionesType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType");
            qName2 = new javax.xml.namespace.QName("", "codigoDescripcion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayComprobantesAsociadosType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ComprobanteAsociadoType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteAsociadoType");
            qName2 = new javax.xml.namespace.QName("", "comprobanteAsociado");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayItemsType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ItemType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ItemType");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayOtrosTributosType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.OtroTributoType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "OtroTributoType");
            qName2 = new javax.xml.namespace.QName("", "otroTributo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArrayPuntosVentaType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.PuntoVentaType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "PuntoVentaType");
            qName2 = new javax.xml.namespace.QName("", "puntoVenta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ArraySubtotalesIVAType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.SubtotalIVAType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SubtotalIVAType");
            qName2 = new javax.xml.namespace.QName("", "subtotalIVA");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AuthRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.AuthRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "AutorizarComprobanteResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CAEAResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.CAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionStringType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionStringType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoDescripcionType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "CodigoTipoAutorizacionSimpleType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.CodigoTipoAutorizacionSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteAsociadoType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ComprobanteAsociadoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ComprobanteCAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteCAEResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ComprobanteCAEResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ComprobanteType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ComprobanteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultaComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultaComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarAlicuotasIVARequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarAlicuotasIVAResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAEntreFechasRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAEntreFechasResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEARequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarComprobanteResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCondicionesIVARequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCondicionesIVAResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCotizacionMonedaRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarCotizacionMonedaResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarMonedasRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarMonedasResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPtosVtaCAEANoInformadosRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPtosVtaCAEANoInformadosResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaCAEARequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAEARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaCAERequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAERequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarPuntosVentaResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposComprobanteRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposComprobanteResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDocumentoRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposDocumentoResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposTributoRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarTiposTributoResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUltimoComprobanteAutorizadoRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUltimoComprobanteAutorizadoResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUnidadesMedidaRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultarUnidadesMedidaResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ConsultaUltimoComprobanteAutorizadoRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ConsultaUltimoComprobanteAutorizadoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DecimalSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "DummyResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.DummyResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ExceptionResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ImporteSubtotalSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ImporteTotalSimpleType");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoPtoVtaResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoRequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarCAEANoUtilizadoResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarComprobanteCAEARequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "InformarComprobanteCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ItemType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ItemType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "NumeroComprobanteSimpleType");
            cachedSerQNames.add(qName);
            cls = long.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "NumeroPuntoVentaSimpleType");
            cachedSerQNames.add(qName);
            cls = short.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "OtroTributoType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.OtroTributoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "PuntoVentaType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.PuntoVentaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "ResultadoSimpleType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.ResultadoSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SiNoSimpleType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.SiNoSimpleType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitarCAEARequestType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEARequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitarCAEAResponseType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEAResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SolicitudCAEAType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.SolicitudCAEAType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "SubtotalIVAType");
            cachedSerQNames.add(qName);
            cls = FEV1.dif.afip.gov.ar.wmtx.SubtotalIVAType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public FEV1.dif.afip.gov.ar.wmtx.DummyResponseType dummy() throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/dummy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "dummy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.DummyResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.DummyResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.DummyResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType autorizarComprobante(FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/autorizarComprobante");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "autorizarComprobante"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

	 	
 		MessageContext messageContext = _call.getMessageContext();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
	
			XMLUtils.PrettyElementToStream(messageContext
					.getRequestMessage().getSOAPEnvelope().getAsDOM(), bos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
            	FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType fECAEResponse = (FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType) _resp;
            	fECAEResponse.setRequestEnviado(bos.toByteArray());				
                return fECAEResponse;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEAResponseType solicitarCAEA(FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/solicitarCAEA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "solicitarCAEA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.SolicitarCAEAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEAResponseType informarComprobanteCAEA(FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/informarComprobanteCAEA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "informarComprobanteCAEA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.InformarComprobanteCAEAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoResponseType consultarUltimoComprobanteAutorizado(FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarUltimoComprobanteAutorizado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarUltimoComprobanteAutorizado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType consultarComprobante(FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarComprobante");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarComprobante"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});
 MessageContext messageContext = _call.getMessageContext(); 
 ByteArrayOutputStream bos = new ByteArrayOutputStream();
	try {
		 
		XMLUtils.PrettyElementToStream(messageContext.getResponseMessage().getSOAPEnvelope().getAsDOM(), bos);
	} catch (Exception e) {
		e.printStackTrace();
	}

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            ConsultarComprobanteResponseType consultarComprobanteResponseType = null;
            try {
            	consultarComprobanteResponseType = (FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType) _resp;
            	consultarComprobanteResponseType.setXmlResponse(bos.toByteArray());
            	return consultarComprobanteResponseType;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteResponseType consultarTiposComprobante(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposComprobante");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposComprobante"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposComprobanteResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoResponseType consultarTiposDocumento(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposDocumento");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposDocumento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposDocumentoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVAResponseType consultarAlicuotasIVA(FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarAlicuotasIVA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarAlicuotasIVA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarAlicuotasIVAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVAResponseType consultarCondicionesIVA(FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarCondicionesIVA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCondicionesIVA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarCondicionesIVAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasResponseType consultarMonedas(FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarMonedas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarMonedas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarMonedasResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaResponseType consultarCotizacionMoneda(FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarCotizacionMoneda");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCotizacionMoneda"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarCotizacionMonedaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaResponseType consultarUnidadesMedida(FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarUnidadesMedida");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarUnidadesMedida"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarUnidadesMedidaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType consultarPuntosVenta(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarPuntosVenta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarPuntosVenta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType consultarPuntosVentaCAE(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAERequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarPuntosVentaCAE");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarPuntosVentaCAE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType consultarPuntosVentaCAEA(FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarPuntosVentaCAEA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarPuntosVentaCAEA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarPuntosVentaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoResponseType informarCAEANoUtilizado(FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/informarCAEANoUtilizado");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "informarCAEANoUtilizado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoResponseType consultarTiposTributo(FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposTributo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarTiposTributo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarTiposTributoResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaResponseType informarCAEANoUtilizadoPtoVta(FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/informarCAEANoUtilizadoPtoVta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "informarCAEANoUtilizadoPtoVta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.InformarCAEANoUtilizadoPtoVtaResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAResponseType consultarCAEA(FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEARequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarCAEA");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCAEA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosResponseType consultarPtosVtaCAEANoInformados(FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarPtosVtaCAEANoInformados");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarPtosVtaCAEANoInformados"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarPtosVtaCAEANoInformadosResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasResponseType consultarCAEAEntreFechas(FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasRequestType parameters) throws java.rmi.RemoteException, FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://impl.service.wsmtxca.afip.gov.ar/service/consultarCAEAEntreFechas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "consultarCAEAEntreFechas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, FEV1.dif.afip.gov.ar.wmtx.ConsultarCAEAEntreFechasResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) {
              throw (FEV1.dif.afip.gov.ar.wmtx.ExceptionResponseType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
