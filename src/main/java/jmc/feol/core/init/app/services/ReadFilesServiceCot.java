package jmc.feol.core.init.app.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Properties;





import jmc.feol.core.dao.impl.ParametrizacionDAOImpl;
import jmc.feol.core.model.Parametrizacion;
import jmc.feol.core.service.ServicesManager;
import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.Constants;
import jmc.feol.util.FileUtil;
import jmc.feol.util.HibernateUtil;
import jmc.feol.util.email.Email;
import jmc.feol.util.email.SendEmailThread;

import org.hibernate.SessionFactory;

public class ReadFilesServiceCot {

	
	private ServicesManager servicesManager;
	
	public ServicesManager getServicesManager() {
		return servicesManager;
	}

	public void setServicesManager(ServicesManager servicesManager) {
		this.servicesManager = servicesManager;
	}

	public void checkCot(){
		
	}
	
	public void run() {
		
		try {
			boolean useService = true;
			
//			if (useService) {				
//					//Open Service de lectura de cola de facturas
//					String url = "http://localhost:8080/FEOL/checkCotByFile" ;
//					Long valor = 3000l;
//					Thread.sleep(valor);		
//					System.out.println("Inicio ListenerReadFiles COT");
//					openURL(url);				
//			}
			
			while(true){
				try {
					servicesManager.procesarFacturaByFilesCot();
				} catch (Exception e) {
					e.printStackTrace();				
				}
				

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {

					e.printStackTrace();
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
		
	private static void openURL(String url){
		URL method = null; 
		try {
			method = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			method.openStream();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
