package jmc.feol.core.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.Base64;
import org.apache.axis.encoding.XMLType;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import jmc.feol.core.model.Empresa;
import jmc.feol.core.service.CredencialAfipManager;

public class CredencialAfipManagerImpl implements CredencialAfipManager {

	public Empresa getCredencial(Empresa empresa) throws Exception {

		String LoginTicketResponse = null;

		String endpoint = empresa.getEndpoint();
		String service = empresa.getService();
		String dstDN = empresa.getDstDN();

		String p12file = empresa.getP12File();
		String signer = empresa.getSigner();
		String p12pass = empresa.getP12pass();

		Long TicketTime = empresa.getTicketTime();

		// Create LoginTicketRequest_xml_cms

		byte[] LoginTicketRequest_xml_cms = null;
		
		
		LoginTicketRequest_xml_cms = create_cms(p12file, p12pass, signer, dstDN, service, TicketTime, empresa);

		// Get LoginTicketResponse by teh invocation of AFIP wsaa

		LoginTicketResponse = invoke_wsaa(LoginTicketRequest_xml_cms, endpoint);
		// Get token & sign from LoginTicketResponse

		Reader tokenReader = new StringReader(LoginTicketResponse);
		Document tokenDoc = new SAXReader(false).read(tokenReader);

		String token = tokenDoc.valueOf("/loginTicketResponse/credentials/token");
		String sign = tokenDoc.valueOf("/loginTicketResponse/credentials/sign");

		// System.out.println("TOKEN: " + token);
		// System.out.println("SIGN: " + sign);

		empresa.setSignToken(sign);
		empresa.setToken(token);

		return empresa;
	}

	private static String invoke_wsaa(byte[] LoginTicketRequest_xml_cms, String endpoint) throws Exception {
		String LoginTicketResponse = null;
		Service service = new Service();
		Call call = (Call) service.createCall();

		//
		// Prepare the call for the Web service
		//
		call.setTargetEndpointAddress(new java.net.URL(endpoint));
		call.setOperationName("loginCms");
		call.addParameter("request", XMLType.XSD_STRING, ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);

		/*
		 * Make the actual call and assign the answer to a String
		 */

		LoginTicketResponse = (String) call.invoke(new Object[] { Base64.encode(LoginTicketRequest_xml_cms) });

		return (LoginTicketResponse);
	}

	//
	// Create the CMS Message
	//

	private static byte[] create_cms(String p12file, String p12pass, String signer, String dstDN, String service,
			Long TicketTime, Empresa empresa) throws Exception {
		// System.out.println("Entro a create_cms");
		PrivateKey pKey = null;
		X509Certificate pCertificate = null;
		byte[] asn1_cms = null;
		CertStore cstore = null;
		String LoginTicketRequest_xml;
		String SignerDN = null;

		

		if (empresa.getUsePKCS12() != null && empresa.getUsePKCS12() == false) {
			pKey = getPrivateKey(empresa.getPrivateKeyFile());
			pCertificate = getPublicCertificate(empresa.getCertFile());
		} else {
			//
			// Manage Keys & Certificates
			//
			// Create a keystore using keys from the pkcs#12 p12file
			KeyStore ks = KeyStore.getInstance("pkcs12");
			// System.out.println("La ruta pkcs12 es: " + p12file);
			FileInputStream p12stream = new FileInputStream(p12file);
			ks.load(p12stream, p12pass.toCharArray());
			p12stream.close();
			// Get Certificate & Private key from KeyStore
			pKey = (PrivateKey) ks.getKey(signer, p12pass.toCharArray());
			pCertificate = (X509Certificate) ks.getCertificate(signer);
		}
		SignerDN = pCertificate.getSubjectDN().toString();

		// Create a list of Certificates to include in the final CMS
		ArrayList<X509Certificate> certList = new ArrayList<X509Certificate>();
		certList.add(pCertificate);

		if (Security.getProvider("BC") == null) {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		}

		cstore = CertStore.getInstance("Collection", new CollectionCertStoreParameters(certList), "BC");

		//
		// Create XML Message
		//
		LoginTicketRequest_xml = create_LoginTicketRequest(SignerDN, dstDN, service, TicketTime);

		//
		// Create CMS Message
		//
		try {
			// Create a new empty CMS Message
			CMSSignedDataGenerator gen = new CMSSignedDataGenerator();

			// Add a Signer to the Message
			gen.addSigner(pKey, pCertificate, CMSSignedDataGenerator.DIGEST_SHA1);

			// Add the Certificate to the Message
			gen.addCertificatesAndCRLs(cstore);

			// Add the data (XML) to the Message
			CMSProcessable data = new CMSProcessableByteArray(LoginTicketRequest_xml.getBytes());

			// Add a Sign of the Data to the Message
			CMSSignedData signed = gen.generate(data, true, "BC");

			//
			asn1_cms = signed.getEncoded();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (asn1_cms);
	}

	public static X509Certificate getPublicCertificate(String filename) throws Exception {

		try {
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");						
			Certificate cert = (Certificate) certificateFactory.generateCertificate(new FileInputStream(filename));
			return (X509Certificate) cert ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static PrivateKey getPrivateKey(String filename) throws Exception {

		byte[] keyBytes = Files.readAllBytes(Paths.get(filename));

		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
		
		
		
	}
	
	
	//
	// Create XML Message for AFIP wsaa
	//
	private static String create_LoginTicketRequest(String SignerDN, String dstDN, String service, Long TicketTime) {

		String LoginTicketRequest_xml;

		Date GenTime = new Date();
		GregorianCalendar gentime = new GregorianCalendar();
		GregorianCalendar exptime = new GregorianCalendar();
		String UniqueId = new Long(GenTime.getTime() / 1000).toString();

		exptime.setTime(new Date(GenTime.getTime() + TicketTime));

		XMLGregorianCalendarImpl XMLGenTime = new XMLGregorianCalendarImpl(gentime);
		XMLGregorianCalendarImpl XMLExpTime = new XMLGregorianCalendarImpl(exptime);

		// System.out.println("GenTime " + gentime);

		// System.out.println("ExpTime " + exptime);

		LoginTicketRequest_xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<loginTicketRequest version=\"1.0\">" + "<header>" + "<source>" + SignerDN + "</source>"
				+ "<destination>" + dstDN + "</destination>" + "<uniqueId>" + UniqueId + "</uniqueId>"
				+ "<generationTime>" + XMLGenTime + "</generationTime>" + "<expirationTime>" + XMLExpTime
				+ "</expirationTime>" + "</header>" + "<service>" + service + "</service>" + "</loginTicketRequest>";

		return (LoginTicketRequest_xml);
	}

}