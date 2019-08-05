package jmc.feol.util.email;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestEmail {

	public static void main(String[] args) {
		
		File file1 = new File("/tmp/wifi-0gmjQk.log");
		File file2 = new File("/tmp/wifi-0nQDj9.log");
		List<File> filelist = new ArrayList<File>();
		filelist.add(file1);
		filelist.add(file2);
		
		Email email = new Email("Subject","Mensaje",null,"libre@libre.net.ar");
		Properties prop = new Properties();
		
		prop.setProperty("mail.smtp.enviante", "libre@libre.net.ar");
		prop.setProperty("mail.smtp.host", "cr1.toservers.com");
		prop.setProperty("mail.smtp.starttls.enable", "false");
		prop.setProperty("mail.smtp.port", "465");
		prop.setProperty("mail.smtp.user", "libre@libre.net.ar");
		prop.setProperty("mail.smtp.auth", "false");	
		prop.setProperty("mail.smtp.pass", "libre");
		
		
		//cr1.toservers.com
		SendEmailThread sendMailThread = new SendEmailThread(prop,email,"libre@libre.net.ar");
		sendMailThread.start();
		
		

	}

}
