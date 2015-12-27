package jmc.feol.core.init.app;

/*
 File : ApplicationWatch.java
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import jmc.feol.core.init.app.services.ReadFilesServiceCot;

public class ListenerReadFilesCot implements ServletContextListener {

	public static long applicationInitialized = 0L;

	/* Application Startup Event */
	public void contextInitialized(ServletContextEvent ce) {
		applicationInitialized = System.currentTimeMillis();
		ReadFilesServiceCot ffs = new ReadFilesServiceCot();
		ffs.checkCot();
	}

	/* Application Shutdown Event */
	public void contextDestroyed(ServletContextEvent ce) {
	}

}