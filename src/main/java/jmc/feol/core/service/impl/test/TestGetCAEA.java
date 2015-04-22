package jmc.feol.core.service.impl.test;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import jmc.feol.core.model.Empresa;
import jmc.feol.core.service.impl.CredencialAfipManagerImpl;
import jmc.feol.util.DateUtil;
import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FEAuthRequest;
import FEV1.dif.afip.gov.ar.FECAEAGetResponse;
import FEV1.dif.afip.gov.ar.FECompConsResponse;
import FEV1.dif.afip.gov.ar.FECompConsultaReq;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.ServiceSoapProxy;
import FEV1.dif.afip.gov.ar.wmtx.AuthRequestType;
import FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultaComprobanteRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ItemType;
import FEV1.dif.afip.gov.ar.wmtx.MTXCAServicePortTypeProxy;
import FEV1.dif.afip.gov.ar.wmtx.SubtotalIVAType;


public class TestGetCAEA {


	  public static void main (String args[]) {
		  Empresa empresa = new Empresa();
			
		  CredencialAfipManagerImpl credencialAfipManagerImpl = new CredencialAfipManagerImpl();
			try{
			empresa.setIdEmpresa(1l);
			empresa.setCuit("33709732949");
			empresa.setNombre("Sandro");
			empresa.setEndpoint("https://wsaa.afip.gov.ar/ws/services/LoginCms");
			empresa.setService("wsfe");
			empresa.setDstDN("CN=wsaa, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239");
			empresa.setP12File("/Users/juanmanuelcarrascal/projects/jmc/feol/Certificados/Certificados/punto/punto1.p12");
			empresa.setP12pass("123456");
			empresa.setTicketTime(36000000l);
			empresa.setSigner("punto");
			
			//empresa.setRutaArchivoConfigAfip("c:/FacturaElectronica/wsaa_client_kila.properties");
			empresa = credencialAfipManagerImpl.getCredencial(empresa);
			}	catch(Exception e){
				e.printStackTrace();
			}
	  
	  		
			 FEAuthRequest feAuth = new FEAuthRequest();
					
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());
		System.out.println(empresa.getToken());
		System.out.println(empresa.getSignToken());

		feAuth.setCuit(Long.parseLong(empresa.getCuit()));
		
		getCaea(feAuth);
		
		
}

	  private static void getCaea(FEAuthRequest feAuth){
		 
		  	ServiceSoapProxy service = new ServiceSoapProxy("https://servicios1.afip.gov.ar/wsfev1/service.asmx");
			
			try {
				FECAEAGetResponse fECompConsultaResponse   = service.FECAEASolicitar(feAuth, 201504, Short.parseShort("2"));
				System.out.println("");
						
			} catch (Exception e) {			
				e.printStackTrace();
			}				
		
			
		}
	  }		  
  

	  