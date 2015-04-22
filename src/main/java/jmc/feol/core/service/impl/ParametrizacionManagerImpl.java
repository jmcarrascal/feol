package jmc.feol.core.service.impl;

import java.util.List;

import jmc.feol.core.dao.GenericDAO;
import jmc.feol.core.model.Parametrizacion;
import jmc.feol.core.service.ParametrizacionManager;
import jmc.feol.util.exception.DataAccessDPIv1Exception;

public class ParametrizacionManagerImpl implements ParametrizacionManager {

	private GenericDAO<Parametrizacion> parametrizacionDAO;
	
	/* DAOS */
	public GenericDAO<Parametrizacion> getParametrizacionDAO() {
		return parametrizacionDAO;
	}

	public void setParametrizacionDAO(GenericDAO<Parametrizacion> parametrizacionDAO) {
		this.parametrizacionDAO = parametrizacionDAO;
	}

	/* METODOS */
	public Parametrizacion getParametrizacionByPrimaryKey(Long idPrimaryKey) {
		return parametrizacionDAO.getByPrimaryKey(idPrimaryKey);
	}

	
	public List<Parametrizacion> getAllParametrizacion()
			throws DataAccessDPIv1Exception {
		
		return parametrizacionDAO.getAll();
	}


	public void updateParametrizacion(Parametrizacion parametrizacion)
			throws DataAccessDPIv1Exception {
		parametrizacionDAO.update(parametrizacion);
	}
}
