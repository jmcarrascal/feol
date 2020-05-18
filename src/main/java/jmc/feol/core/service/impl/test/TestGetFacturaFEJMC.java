package jmc.feol.core.service.impl.test;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import jmc.feol.core.model.Empresa;
import jmc.feol.core.service.impl.CredencialAfipManagerImpl;
import jmc.feol.util.DateUtil;
import FEV1.dif.afip.gov.ar.wmtx.AuthRequestType;
import FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultaComprobanteRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ItemType;
import FEV1.dif.afip.gov.ar.wmtx.MTXCAServicePortTypeProxy;
import FEV1.dif.afip.gov.ar.wmtx.SubtotalIVAType;


public class TestGetFacturaFEJMC {


	  public static void main (String args[]) {
		  Empresa empresa = new Empresa();
			
		  CredencialAfipManagerImpl credencialAfipManagerImpl = new CredencialAfipManagerImpl();
			try{
			empresa.setIdEmpresa(1l);
			empresa.setCuit("20280377695");
			empresa.setNombre("JMC");
			empresa.setEndpoint("https://wsaa.afip.gov.ar/ws/services/LoginCms");
			empresa.setService("wsmtxca");
			empresa.setDstDN("CN=wsaa, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239");
			//empresa.setP12File("/Users/juanmanuelcarrascal/projects/ERP/Certificados/droval/2019/ks.p12");
			
			empresa.setPrivateKeyFile("/Users/juanmanuelcarrascal/projects/ERP/Certificados/jmc/2019/private.key");
			empresa.setCertFile("/Users/juanmanuelcarrascal/projects/ERP/Certificados/jmc/2019/cert.crt");
			empresa.setUsePKCS12(false);
			//empresa.setP12pass("123456");
			empresa.setTicketTime(36000000l);
			//empresa.setSigner("droval");
			
			//empresa.setRutaArchivoConfigAfip("c:/FacturaElectronica/wsaa_client_kila.properties");
			empresa = credencialAfipManagerImpl.getCredencial(empresa);
			}	catch(Exception e){
				e.printStackTrace();
			}
	  
	  		
			System.out.println(empresa.getToken());
			System.out.println(empresa.getSignToken());

		
		
}

	  
}
	  