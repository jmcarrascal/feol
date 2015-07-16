package jmc.feol.core.service.impl;

import jmc.feol.core.dao.GenericDAO;
import jmc.feol.core.model.Parametrizacion;
import jmc.feol.core.service.ReporteManager;

public class ReporteManagerImpl implements ReporteManager {


	private GenericDAO<Parametrizacion> parametrizacionDAO;
	

	public GenericDAO<Parametrizacion> getParametrizacionDAO() {
		return parametrizacionDAO;
	}

	public void setParametrizacionDAO(GenericDAO<Parametrizacion> parametrizacionDAO) {
		this.parametrizacionDAO = parametrizacionDAO;
	}

}
