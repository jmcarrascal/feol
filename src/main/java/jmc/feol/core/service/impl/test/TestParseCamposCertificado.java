package jmc.feol.core.service.impl.test;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jmc.feol.core.model.Usuario;


public class TestParseCamposCertificado {

	public static void main(String[] args){
		String c = "AR";
		String o = "Ministerio Público de la Provincia de Buenos Aires";
		String ou = "Se desempeña como Oficial 4 en la oficina FISCALIA GENERAL - Oficina de Archivo";
		String cn = "Carlos Gomez";
		String e = "cgomez@mpba.gov.ar";
		
		String sn = "C=AR, O=Ministerio Público de la Provincia de Buenos Aires, OU=Se desempeña como Oficial 4 en la oficina FISCALIA GENERAL - Oficina de Archivo, CN=Carlos Gomez, EMAILADDRESS=cgomez@mpba.gov.ar";
		/*
		 
		 Validar que el usuario se desempeña en la oficina "A"		 
		 1- validar que el texto primero es "Se desempeña como "
		 2- validar que el texto segundo es " en la oficina "
		
		*/
		getUsuariobyCert(sn);
		
	}
	private static Usuario getUsuariobyCert(String sn){
		
		String[] fields = sn.split(",");
		String email = "";
		String cn = "";
		String organismo = "";
		String unidadOrganizacional = "";
		
		// se recuperan los valores de los campos del asunto
		for (String field: fields) {
			String[] codeValue = field.split("=");
			String code = codeValue[0];
			if (code.startsWith(" ")) {
				code = code.substring(1);
			}
			String value = codeValue[1];
			if (code.equals("EMAILADDRESS")) {
				email = value;				
			} else if (code.equals("CN")) {
				cn = value;				
			} else if (code.equals("O")) {
				organismo = value;
			} else if (code.equals("OU")) {
				unidadOrganizacional = value;				
			}			
		}
		Usuario usuario = null;
		if (!validateEmailAddress(email))
			return null;
		
		usuario = integridadOrganismoOrganizacional(unidadOrganizacional); 		
		if ( usuario == null)
			return null;
		
		usuario.setEmail(email.trim());
		usuario.setOrganismo(organismo.trim());
		usuario.setNombre(cn.trim());

		return usuario;		
	}  

	private static boolean validateEmailAddress(String emailAddress) {
		if (emailAddress == null) {
			return false;
		}
		boolean result = true;
		try {
			@SuppressWarnings("unused")
			InternetAddress emailAddr = new InternetAddress(emailAddress);
			if (!hasNameAndDomain(emailAddress)) {
				result = false;
			}
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	private static boolean hasNameAndDomain(String emailAddress) {
		String[] tokens = emailAddress.split("@");
		return (tokens.length == 2 && tokens[0].length() > 0 && tokens[1].length() > 0);
	}

	private static Usuario integridadOrganismoOrganizacional(String ou) {
		Usuario usuario = new Usuario();
		try{
			String[] parrafos = ou.split("Se desempeña como ");
			String[] titulos = parrafos[1].split("en la oficina ");
			usuario.setCargo(titulos[0].trim());
			usuario.setOficina(titulos[1].trim());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return usuario;		
	}

}
