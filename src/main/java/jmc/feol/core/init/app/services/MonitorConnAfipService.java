package jmc.feol.core.init.app.services;

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

public class MonitorConnAfipService implements Runnable {

	public void run() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		ParametrizacionDAOImpl parametrizacionDAO = new ParametrizacionDAOImpl(
				sessionFactory);
		try {
			if (parametrizacionDAO
					.getByPrimaryKey(Constants.ID_USO_LISTENERCONNAFIP)
					.getValor().trim().equals("true")) {
				System.out.println("Inicio ListenerMonitorConnAfip");
				Long periodo = 10000l;
				try {
					periodo = Long.parseLong(parametrizacionDAO
							.getByPrimaryKey(
									Constants.ID_LISTENERCONNAFIP_TIEMPO)
							.getValor());
				} catch (NumberFormatException ne) {
					ne.printStackTrace();
				}
				FacturaManagerImpl fm = new FacturaManagerImpl();
				boolean useService = true;
				Timestamp fechaEnvioCorreo = null;
				
				while (useService) {
					//System.out.println("Inicio ListenerMonitorConnAfip");
					// Chequeo funcionaiento AFIP
					boolean connAFIP = false;
					if (!connAFIP) {
						// Pregunto si hace mas de una hora que lo envié si es
						// asi mando el correo
						if (FileUtil.getHoursCompareEntryToNow(
								fechaEnvioCorreo, 1)) {
							// Envio el correo
							sendMail("Error al intentar conectar con AFIP","Se detectó que el servicio de AFIP se encuentra bajo o no hay conexión con el mismo a las: " + new Timestamp(System.currentTimeMillis()),parametrizacionDAO);
							// actualizo la fechaEnvioCorreo
							fechaEnvioCorreo = new Timestamp(System.currentTimeMillis());							
						}
					}
					Thread.sleep(periodo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void initMonitor(){
		Thread thread=new Thread(this);		 
		thread.start();	
	}


	private void sendMail(String subject, String error, ParametrizacionDAOImpl parametrizacionDAO) {
		// Cargo los datos del EMail
		String mailAdminitrador = "";
		try {
			mailAdminitrador = parametrizacionDAO.getByPrimaryKey(
					Constants.ID_MAIL_ADMNISTRADOR).getValor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Email email = new Email(subject, error, null, mailAdminitrador);
		Properties props = null;
		try {
			props = getPropertiesEmail(parametrizacionDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SendEmailThread emailManager = new SendEmailThread(props, email);
		emailManager.start();
	}
	
	public Properties getPropertiesEmail(ParametrizacionDAOImpl parametrizacionDAO) throws Exception{
		Properties props = new Properties();
		long i = 50l;
		while(i < 66){
			Parametrizacion parametrizacion = parametrizacionDAO.getByPrimaryKey(i);			
			if (parametrizacion!=null){
				props.put(parametrizacion.getDescrip().trim(), parametrizacion.getValor().trim());				
			}			
			i++;
		}			
		return props;
	}


	
	
}
