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
import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.Constants;
import jmc.feol.util.FileUtil;
import jmc.feol.util.HibernateUtil;
import jmc.feol.util.email.Email;
import jmc.feol.util.email.SendEmailThread;

import org.hibernate.SessionFactory;

public class GetImageChequeService implements Runnable {

	public void run() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		ParametrizacionDAOImpl parametrizacionDAO = new ParametrizacionDAOImpl(
				sessionFactory);
		try {
			boolean useService = false;
			try{
			useService= parametrizacionDAO
			.getByPrimaryKey(Constants.ID_USO_LISTENERGETIMAGECHEQUE)
			.getValor().trim().equals("true");
			}catch(Exception e){
				
			}
			try {
				if(parametrizacionDAO.getByPrimaryKey(Constants.ID_USE_PROXY).getValor().equals("true")){
					//Seteo de Proxy
					System.setProperty("proxySet", "true");
					System.setProperty("http.proxyHost", parametrizacionDAO.getByPrimaryKey(Constants.ID_PROXY_URL).getValor());
					System.setProperty("http.proxyPort", parametrizacionDAO.getByPrimaryKey(Constants.ID_PROXY_PORT).getValor());				
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			if (useService) {
				System.out.println("Inicio ListenerGetImageCheque");
				
				Long periodo = 300000l;
				
				while (useService) {					
					//Open Service de lectura de cola de facturas
					String dominio = parametrizacionDAO.getByPrimaryKey(Constants.ID_DOMINIO_LISTENERFORWARDFACTURA).getValor().trim();  
					String url = "http://" + dominio + "/" + parametrizacionDAO
					.getByPrimaryKey(Constants.ID_APP_WEB)
					.getValor() + "/checkGetImageCheque" ;
					openURL(url);
					Thread.sleep(periodo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void initListener(){
		Thread thread=new Thread(this);		 
		thread.start();	
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
