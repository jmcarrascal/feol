/**
 * ServiceSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fex.dif.afip.gov.ar;

public class ServiceSoapStubDesa extends org.apache.axis.client.Stub implements fex.dif.afip.gov.ar.ServiceSoapDesa {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[16];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXAuthorize");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Cmp"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXRequest"), fex.dif.afip.gov.ar.ClsFEXRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponseAuthorize"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXAuthorizeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetCMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Cmp"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXGetCMP"), fex.dif.afip.gov.ar.ClsFEXGetCMPDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetCMPResponse"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXGetCMPResponseDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetCMPResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_Tipo_Cbte");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Tipo_Cbte"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_Tipo_CbteDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_Tipo_CbteResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_Tipo_Expo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Tex"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_TexDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_Tipo_ExpoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_Incoterms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Inc"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_IncDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_IncotermsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_Idiomas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Idi"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_IdiDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_IdiomasResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_UMed");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Umed"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_UmedDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_UMedResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_DST_pais");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_DST_pais"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_DST_paisDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_DST_paisResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_DST_CUIT");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_DST_cuit"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_DST_cuitDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_DST_CUITResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_MON");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Mon"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_MonDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_MONResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetLast_CMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEX_LastCMP"), fex.dif.afip.gov.ar.ClsFEX_LastCMPDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponseLast_CMP"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponseLast_CMPDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetLast_CMPResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXDummy");
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "DummyResponse"));
        oper.setReturnClass(fex.dif.afip.gov.ar.DummyResponseDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXDummyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_Ctz");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Mon_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Ctz"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_CtzDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_CtzResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetLast_ID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_LastID"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_LastIDDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetLast_IDResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXGetPARAM_PtoVenta");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_PtoVenta"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_PtoVentaDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_PtoVentaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FEXCheck_Permiso");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest"), fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ID_Permiso"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Dst_merc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_CheckPermiso"));
        oper.setReturnClass(fex.dif.afip.gov.ar.FEXResponse_CheckPermisoDesa.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXCheck_PermisoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

    }

    public ServiceSoapStubDesa() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ServiceSoapStubDesa(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ServiceSoapStubDesa(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfClsFEXResponse_DST_cuit");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_DST_cuitDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_DST_cuit");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_DST_cuit");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfClsFEXResponse_DST_pais");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_DST_paisDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_DST_pais");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_DST_pais");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfClsFEXResponse_Idi");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_IdiDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Idi");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Idi");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfClsFEXResponse_Inc");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_IncDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Inc");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Inc");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfClsFEXResponse_Mon");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_MonDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Mon");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Mon");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfClsFEXResponse_PtoVenta");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_PtoVentaDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_PtoVenta");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_PtoVenta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfClsFEXResponse_Tex");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_TexDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Tex");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Tex");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfClsFEXResponse_Tipo_Cbte");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_Tipo_CbteDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Tipo_Cbte");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Tipo_Cbte");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfClsFEXResponse_UMed");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_UMedDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_UMed");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_UMed");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfCmp_asoc");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.Cmp_asocDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Cmp_asoc");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Cmp_asoc");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfItem");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ItemDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Item");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ArrayOfPermiso");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.PermisoDesa[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Permiso");
            qName2 = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Permiso");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEX_LastCMP");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEX_LastCMPDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEX_LastCMP_Response");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEX_LastCMP_ResponseDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXAuthRequest");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXErr");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXErrDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXEvents");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXEventsDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXGetCMP");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXGetCMPDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXGetCMPR");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXGetCMPRDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXOutAuthorize");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXOutAuthorizeDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXRequest");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXRequestDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_CheckPermiso");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_CheckPermisoDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Ctz");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_CtzDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_DST_cuit");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_DST_cuitDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_DST_pais");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_DST_paisDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Idi");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_IdiDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Inc");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_IncDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_LastID");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_LastIDDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Mon");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_MonDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_PtoVenta");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_PtoVentaDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Tex");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_TexDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_Tipo_Cbte");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_Tipo_CbteDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "ClsFEXResponse_UMed");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ClsFEXResponse_UMedDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Cmp_asoc");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.Cmp_asocDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "DummyResponse");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.DummyResponseDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetCMPResponse");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXGetCMPResponseDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_CheckPermiso");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_CheckPermisoDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Ctz");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_CtzDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_DST_cuit");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_DST_cuitDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_DST_pais");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_DST_paisDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Idi");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_IdiDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Inc");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_IncDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_LastID");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_LastIDDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Mon");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_MonDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_PtoVenta");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_PtoVentaDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Tex");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_TexDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Tipo_Cbte");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_Tipo_CbteDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponse_Umed");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponse_UmedDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponseAuthorize");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXResponseLast_CMP");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.FEXResponseLast_CMPDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Item");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.ItemDesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "Permiso");
            cachedSerQNames.add(qName);
            cls = fex.dif.afip.gov.ar.PermisoDesa.class;
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

    public fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa FEXAuthorize(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, fex.dif.afip.gov.ar.ClsFEXRequestDesa cmp) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXAuthorize");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXAuthorize"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth, cmp});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXGetCMPResponseDesa FEXGetCMP(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, fex.dif.afip.gov.ar.ClsFEXGetCMPDesa cmp) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetCMP");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetCMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth, cmp});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXGetCMPResponseDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXGetCMPResponseDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXGetCMPResponseDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_Tipo_CbteDesa FEXGetPARAM_Tipo_Cbte(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_Tipo_Cbte");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_Tipo_Cbte"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_Tipo_CbteDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_Tipo_CbteDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_Tipo_CbteDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_TexDesa FEXGetPARAM_Tipo_Expo(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_Tipo_Expo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_Tipo_Expo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_TexDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_TexDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_TexDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_IncDesa FEXGetPARAM_Incoterms(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_Incoterms");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_Incoterms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_IncDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_IncDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_IncDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_IdiDesa FEXGetPARAM_Idiomas(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_Idiomas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_Idiomas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_IdiDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_IdiDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_IdiDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_UmedDesa FEXGetPARAM_UMed(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_UMed");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_UMed"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_UmedDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_UmedDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_UmedDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_DST_paisDesa FEXGetPARAM_DST_pais(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_DST_pais");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_DST_pais"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_DST_paisDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_DST_paisDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_DST_paisDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_DST_cuitDesa FEXGetPARAM_DST_CUIT(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_DST_CUIT");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_DST_CUIT"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_DST_cuitDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_DST_cuitDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_DST_cuitDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_MonDesa FEXGetPARAM_MON(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_MON");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_MON"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_MonDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_MonDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_MonDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponseLast_CMPDesa FEXGetLast_CMP(fex.dif.afip.gov.ar.ClsFEX_LastCMPDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetLast_CMP");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetLast_CMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponseLast_CMPDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponseLast_CMPDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponseLast_CMPDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.DummyResponseDesa FEXDummy() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXDummy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXDummy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.DummyResponseDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.DummyResponseDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.DummyResponseDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_CtzDesa FEXGetPARAM_Ctz(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, java.lang.String mon_id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_Ctz");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_Ctz"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth, mon_id});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_CtzDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_CtzDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_CtzDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_LastIDDesa FEXGetLast_ID(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetLast_ID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetLast_ID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_LastIDDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_LastIDDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_LastIDDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_PtoVentaDesa FEXGetPARAM_PtoVenta(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXGetPARAM_PtoVenta");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXGetPARAM_PtoVenta"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_PtoVentaDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_PtoVentaDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_PtoVentaDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fex.dif.afip.gov.ar.FEXResponse_CheckPermisoDesa FEXCheck_Permiso(fex.dif.afip.gov.ar.ClsFEXAuthRequestDesa auth, java.lang.String ID_Permiso, int dst_merc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://ar.gov.afip.dif.fex/FEXCheck_Permiso");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ar.gov.afip.dif.fex/", "FEXCheck_Permiso"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auth, ID_Permiso, new java.lang.Integer(dst_merc)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fex.dif.afip.gov.ar.FEXResponse_CheckPermisoDesa) _resp;
            } catch (java.lang.Exception _exception) {
                return (fex.dif.afip.gov.ar.FEXResponse_CheckPermisoDesa) org.apache.axis.utils.JavaUtils.convert(_resp, fex.dif.afip.gov.ar.FEXResponse_CheckPermisoDesa.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
