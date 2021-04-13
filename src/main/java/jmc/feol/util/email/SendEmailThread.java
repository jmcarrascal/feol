/*

 * Copyright 2008 Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires.  All Rights Reserved

 * Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires Proprietary and Confidential.

 *

 * You agree to use Your best efforts to protect the software and documentation

 * from unauthorized copy or use. The software source code represents and embodies

 * trade secrets of Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires and/or its licensors.

 * The source code and embodied trade secrets are not licensed to you and any modification,

 * addition or deletion is strictly prohibited. You agree not to disassemble, decompile,

 * or otherwise reverse engineer the software in order to discover the source code and/or

 * the trade secrets contained in the source code.

 *

 *

 * Derecho de autor 2008 Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires.  Todos los derechos reservados.

 * Propiedad de Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires y Confidencial.

 *

 * Por la presente acuerdo hacer mi mayor esfuerzo para proteger el software y la documentaci�n

 * de la copia o el uso no autorizados. El c�digo fuente del software representa e incluye

 * secretos comerciales de Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires y/o sus licenciantes. 

 * No se le otorga licencia del c�digo fuente ni los secretos comerciales incluidos;

 * y cualquier modificaci�n, agregado o eliminaci�n se encuentra estrictamente prohibida.

 * Asimismo, por la presente me comprometo a no desarmar, descompilar, o de alguna forma utilizar

 * t�cnicas de ingenier�a inversa sobre el software para descubrir su fuente y/o los

 * secretos comerciales contenidos en el c�digo fuente.

 *

 */

package jmc.feol.util.email;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
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
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;


import jmc.feol.util.FileUtil;


/**
 * @author clarisa
 *
 */
public class SendEmailThread extends Thread{
		
	// Datos del usuario	
	private Email email;
	private Properties props;
	private String user;
	
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public SendEmailThread(Properties props, Email email) {
		this.email = email;
		this.props = props;
		
	}
	
	public SendEmailThread(Properties props, Email email, String user) {
		this.email = email;
		this.props = props;
		this.user = user;
		
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	// Envia el email	
	public void run() {
		System.out.println("empezoooooooooooooooo el envio del email");
		
		props.put("mail.smtp.user", user);
		
		Session session = Session.getInstance(props);

		
		
		session.setDebug(false);

		MimeMessage message = new MimeMessage(session);
		
		try {
			if (user != null && !user.equals("")){
				message.setFrom(new InternetAddress(user, props.getProperty("mail.smtp.enviante")));
			}else{
				message.setFrom(new InternetAddress(props.getProperty("mail.smtp.user"),props.getProperty("mail.smtp.enviante")));
			}
			
			
			// A quien va dirigido
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));						
			
			message.setSubject(email.getSubject());
			
			message.setText(email.getMessage());
			
			message.addHeaderLine("");
			
		} catch (AddressException e) {			
			e.printStackTrace();
		} catch (MessagingException e) {			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
	            
				if (email.getAdjunto() != null){
		            BodyPart adjunto = new MimeBodyPart();
					adjunto.setDataHandler(new DataHandler(new FileDataSource(email.getAdjunto())));
					adjunto.setFileName(email.getAdjunto().getName());					
					multiParte.addBodyPart(adjunto);
				}
	
	            message.setContent(multiParte);				
				
	            //System.out.println("Host " + props.getProperty("mail.smtp.host"));
				//System.out.println("User" + user);
				//System.out.println("PassWord" + props.getProperty("mail.smtp.pass"));
	            
	            t.connect(props.getProperty("mail.smtp.host"),user,props.getProperty("mail.smtp.pass"));				
				t.sendMessage(message,message.getAllRecipients());
				t.close();
			} catch (MessagingException e) {				
				e.printStackTrace();
			}			
		} catch (NoSuchProviderException e) {			
			e.printStackTrace();
		}
		System.out.println("Terminooooooooooooooo el envio del email");
		
	}

}
