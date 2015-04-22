package jmc.feol.core.init.app;

/*
 File : ApplicationWatch.java
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import jmc.feol.core.dao.impl.ParametrizacionDAOImpl;
import jmc.feol.core.init.app.services.ForwardFileFacturaService;
import jmc.feol.util.Constants;
import jmc.feol.util.HibernateUtil;

import org.hibernate.SessionFactory;

public class ListenerForwardFileFactura implements ServletContextListener {

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
		ForwardFileFacturaService ffs = new ForwardFileFacturaService();
		ffs.initListener();		
	}



	/* Application Shutdown Event */
	public void contextDestroyed(ServletContextEvent ce) {
	}

}