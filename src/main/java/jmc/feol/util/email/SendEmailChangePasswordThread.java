package jmc.feol.util.email;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




/**
 * @author clarisa
 *
 */
public class SendEmailChangePasswordThread extends Thread{
		
	// Datos del usuario
	
	private Email email;
	
	
	public SendEmailChangePasswordThread(Email email) {
		this.email = email;
		
	}

	//Arma las propiedades de la conexi�n 
	private Properties getPropertiesConnection(){
		Properties props = new Properties();
		
		//String path = getClass().getProtectionDomain().getCodeSource().
        //getLocation().toString().substring(6);
		

		String webAppPath = "";
		String sep = System.getProperty("file.separator");
		//String path = webAppPath + sep + "RepositorioWeb" +sep+ "WEB-INF"+sep+"classes"+"\\jmc\\util\\email\\connection.properties";
		String path = "C:\\connection.properties";
		//System.out.println("*****"+path);
		//System.out.println("*****"+path2);
		
		File p = new File(path);
		try {
			InputStream p2 = new FileInputStream(p);
			try {
				props.load(p2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		props.put(this.hostKey, this.host);		
		props.setProperty(this.isAvailableTLSKey, Boolean.toString(this.isAvailableTLS));
		props.put(this.portKey, this.port);
		props.put(this.userNameKey, this.userName);		
		props.setProperty(this.isRequireUserAndPassKey, Boolean.toString(this.isRequireUserAndPass));
		*/
		return props;
	}
	
	// Envia el email	
	public void run() {
		System.out.println("empezoooooooooooooooo el envio del email");
		
		Properties props = this.getPropertiesConnection();
			 		
		System.out.println(props.getProperty("dominio"));
		Session session = Session.getDefaultInstance(props);
	    try{
		Store store = session.getStore("pop3");
	    store.connect();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		session.setDebug(true);
		
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		MimeMessage message = new MimeMessage(session);
		
		try {
			// Quien envia el correo
			message.setFrom(new InternetAddress(props.getProperty("mail.smtp.user")));
			// A quien va dirigido
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(props.getProperty("mail.server")));
			
			String subject = email.getSubject() + "@" + props.getProperty("dominio") + ", " + email.getPasswordFrom(); 		
			message.setSubject(subject);
			
			//message.setText(email.getMessage());
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			Transport t = session.getTransport("smtp");
			try {
	            javax.mail.internet.MimeMultipart multiParte = new javax.mail.internet.MimeMultipart();
	            javax.mail.internet.MimeBodyPart texto = new javax.mail.internet.MimeBodyPart();
	            texto.setText(email.getMessage(), "ISO-8859-1");
	            multiParte.addBodyPart(texto);
	            message.setContent(multiParte);
				
				//t.connect(this.userName,this.password);				
				t.send(message);
				t.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Terminooooooooooooooo el envio del email");
		
	}

}
