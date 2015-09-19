package jmc.feol.core.service.cron;



import jmc.feol.core.service.ServicesInitManager;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CheckFileCotCron extends QuartzJobBean {
	private ServicesInitManager servicesInitManager;

	public void setServicesInitManager(ServicesInitManager servicesInitManager) {
		this.servicesInitManager = servicesInitManager;
	}

	protected void executeInternal(JobExecutionContext context)
		throws JobExecutionException {

		servicesInitManager.procesarByFilesCot();

	}
}