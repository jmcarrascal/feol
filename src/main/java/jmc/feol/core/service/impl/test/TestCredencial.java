package jmc.feol.core.service.impl.test;

import jmc.feol.core.model.Empresa;
import jmc.feol.core.service.impl.CredencialAfipManagerImpl;

public class TestCredencial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//System.setProperty("http.proxyHost", "10.3.1.1");
		//System.setProperty("http.proxyPort", "80");

		// TODO Auto-generated method stub
		CredencialAfipManagerImpl credencialAfipManagerImpl = new CredencialAfipManagerImpl();
		try{
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(1l);
		empresa.setCuit("30586412732");
		empresa.setNombre("SIMPA");
		empresa.setEndpoint("https://wsaahomo.afip.gov.ar/ws/services/LoginCms");
		empresa.setService("wsfe");
		empresa.setDstDN("CN=wsaahomo, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239");
		empresa.setP12File("/Users/juanmanuelcarrascal/projects/ERP/Certificados/testjmc/testjmc1.p12");
		empresa.setP12pass("123456");
		empresa.setTicketTime(36000000l);
		empresa.setSigner("jmc");
		
		empresa.setRutaArchivoConfigAfip("c:/FacturaElectronica/wsaa_client_kila.properties");
		empresa = credencialAfipManagerImpl.getCredencial(empresa);
		System.out.println(empresa.getToken());
		System.out.println(empresa.getSignToken());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
