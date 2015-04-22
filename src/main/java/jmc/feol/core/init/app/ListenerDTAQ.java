package jmc.feol.core.init.app;

/*
 File : ApplicationWatch.java
 */

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import jmc.feol.core.dao.impl.ParametrizacionDAOImpl;
import jmc.feol.core.init.app.services.DTAQService;
import jmc.feol.core.init.app.services.ForwardFacturaService;
import jmc.feol.core.init.app.services.ReadFilesService;
import jmc.feol.util.HibernateUtil;

import org.hibernate.SessionFactory;

public class ListenerDTAQ implements ServletContextListener {

	public static long applicationInitialized = 0L;

	/* Application Startup Event */
	public void contextInitialized(ServletContextEvent ce) {
		applicationInitialized = System.currentTimeMillis();
		DTAQService ffs = new DTAQService();
		ffs.initListener();
	}

	/* Application Shutdown Event */
	public void contextDestroyed(ServletContextEvent ce) {
	}

}