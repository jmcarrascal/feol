package jmc.feol.core.init.app;

/*
 File : ApplicationWatch.java
 */

import java.sql.Timestamp;
import java.util.Properties;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;

import jmc.feol.core.dao.impl.ParametrizacionDAOImpl;
import jmc.feol.core.init.app.services.ForwardFacturaService;
import jmc.feol.core.init.app.services.MonitorConnAfipService;
import jmc.feol.core.model.Parametrizacion;
import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.Constants;
import jmc.feol.util.FileUtil;
import jmc.feol.util.HibernateUtil;
import jmc.feol.util.email.Email;
import jmc.feol.util.email.SendEmailThread;

import org.hibernate.SessionFactory;

public class ListenerForwardFactura implements ServletContextListener {

	public static long applicationInitialized = 0L;
	
	
	
	/* Application Startup Event */
	public void contextInitialized(ServletContextEvent ce) {
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		ParametrizacionDAOImpl parametrizacionDAO = new ParametrizacionDAOImpl(sessionFactory);
		
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
		
		applicationInitialized = System.currentTimeMillis();		
		ForwardFacturaService ffs = new ForwardFacturaService();
		ffs.initListener();		
	}



	/* Application Shutdown Event */
	public void contextDestroyed(ServletContextEvent ce) {
	}

}