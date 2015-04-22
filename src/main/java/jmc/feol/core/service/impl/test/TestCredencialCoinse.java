package jmc.feol.core.service.impl.test;

import jmc.feol.core.model.Empresa;
import jmc.feol.core.service.impl.CredencialAfipManagerImpl;

public class TestCredencialCoinse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CredencialAfipManagerImpl credencialAfipManagerImpl = new CredencialAfipManagerImpl();
		try{
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(1l);
		empresa.setCuit("30700442361");
		empresa.setNombre("Coinse");
		empresa.setEndpoint("https://wsaahomo.afip.gov.ar/ws/services/LoginCms"); 
		empresa.setService("wsfe");
		empresa.setDstDN("CN=wsaahomo, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239");
		
		empresa.setP12File("C:/FacturaElectronica/Certificados/ks3.p12");
		empresa.setSigner("coinse");
		empresa.setP12pass("123456");
	
		empresa.setTicketTime(36000000l);
				
		empresa = credencialAfipManagerImpl.getCredencial(empresa);
		System.out.println(empresa.getToken());
		System.out.println(empresa.getSignToken());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

}
