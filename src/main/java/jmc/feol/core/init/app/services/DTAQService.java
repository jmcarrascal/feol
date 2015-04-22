package jmc.feol.core.init.app.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
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

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ConnectionDroppedException;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.IllegalObjectTypeException;
import com.ibm.as400.access.KeyedDataQueue;
import com.ibm.as400.access.KeyedDataQueueEntry;
import com.ibm.as400.access.ObjectDoesNotExistException;

public class DTAQService implements Runnable {

	public void run() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		ParametrizacionDAOImpl parametrizacionDAO = new ParametrizacionDAOImpl(
				sessionFactory);
		try {
			boolean useService = false;
			try{
			useService= parametrizacionDAO
			.getByPrimaryKey(Constants.ID_USO_LISTENERDTAQ)
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
				System.out.println("Inicio DTAQFiles");
				
				
				
				if (useService) {
				}
				
				AS400 host = null;
		   	    byte Key[];
		   	    boolean Continue = false;
		   	    
		   	    Connection conexion;
		   	    KeyedDataQueue dq;

		   		
			 	Integer tamano_clave = Integer.parseInt(parametrizacionDAO.getByPrimaryKey(Constants.ID_DTAQ_TAMANO_CLAVE).getValor());
			 	
			 	String clave = "";
				
			 	clave = parametrizacionDAO.getByPrimaryKey(Constants.ID_DTAQ_CLAVE).getValor();
			 	
				conexion = null;
				dq = null;
				
				AS400Text AS400Value = new AS400Text(tamano_clave);
				Key = AS400Value.toBytes(clave);				
				
		        
		    	String sistema = "";
		        String biblioteca = "";
		        String usuario = "";
		        String usuarioClave = "";
		        String dtaq = ""; 
				
		        sistema = parametrizacionDAO.getByPrimaryKey(Constants.ID_SISTEMA).getValor();
		        biblioteca = parametrizacionDAO.getByPrimaryKey(Constants.ID_DTAQ_LIB).getValor();
		        usuario = parametrizacionDAO.getByPrimaryKey(Constants.ID_USR_AS).getValor();
		        usuarioClave = parametrizacionDAO.getByPrimaryKey(Constants.ID_PASS_AS).getValor();
		        dtaq = parametrizacionDAO.getByPrimaryKey(Constants.ID_DTAQ).getValor();
		        
		        try
		        {
		            host = new AS400(sistema, usuario, usuarioClave);
		            
		        }
		        catch(Exception e)
		        {
		            System.out.println("Fallo la conexion al as400... " + e.toString());
		            
		        }
		        try{
			        String pathDtaQ = "/QSYS.LIB/"+ biblioteca +".LIB/" + dtaq +".DTAQ";
			        dq = new KeyedDataQueue(host,pathDtaQ);
			        Continue = true;
		        }catch(Exception e ){
		        	e.printStackTrace();
		        }
				int i = 0;
				
		        while(Continue){ 
		            try
		            {
		                KeyedDataQueueEntry dqData = dq.read(Key, -1, "EQ");
		                String UserCommand = dqData.getString();
		                UserCommand = UserCommand.trim();
		                Long idSolicitud = 0l;
		                try{
		                	//Invoco la factura
		                	System.out.println("Leo la Cola de Datos: " + UserCommand);
		                	
		                	String letraEmpresa = "";
		                	try{
		                		UserCommand = UserCommand.trim();
		                		if(UserCommand.length()>2){
		                			letraEmpresa = UserCommand.substring(0,2);
		                			idSolicitud = Long.parseLong(UserCommand.substring(2));
		        					//Open Service de lectura de cola de facturas
		        					String dominio = parametrizacionDAO.getByPrimaryKey(Constants.ID_DOMINIO_LISTENERFORWARDFACTURA).getValor().trim();  
		        					String url = "http://" + dominio + "/" + parametrizacionDAO
		        					.getByPrimaryKey(Constants.ID_APP_WEB)
		        					.getValor() + "/getFacturaAs?param1="+letraEmpresa+"&param2="+idSolicitud ;
		        					openURL(url);		                			
		                		}
		                	}catch(Exception e){
		                		e.printStackTrace();
		                		
		                	}
			
			                }catch(Exception e){
			                	e.printStackTrace();
			                }
		            }
		            catch(AS400SecurityException se)
		            {
		                System.out.println("\nSecurity Exception " + se);
		                Continue = false;
		            }
		            catch(ConnectionDroppedException cd)
		            {
		                System.out.println("\nConnection Dropped Exception " + cd);
		                Continue = false;
		            }
		            catch(ErrorCompletingRequestException er)
		            {
		                System.out.println("\nError completing request " + er);
		                Continue = false;
		            }
		            catch(IOException ioe)
		            {
		                System.out.println("\nIO Exception " + ioe);
		                Continue = false;
		            }
		            catch(IllegalObjectTypeException io)
		            {
		                System.out.println("\nIlegal Object Type Exception " + io);
		                Continue = false;
		            }
		            catch(InterruptedException ie)
		            {
		                System.out.println("\nInterrupted Exception " + ie);
		                Continue = false;
		            }
		            catch(ObjectDoesNotExistException ne)
		            {
		                System.out.println("\nObject Does Not Exist Exception " + ne);
		                Continue = false;
		            }
			        
					

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
