/**
 * 
 */
package jmc.feol.core.dao;

import java.util.List;

import jmc.feol.core.model.Cot;
import jmc.feol.core.model.Factura;

import org.springframework.dao.DataAccessException;

/**
 * @author Juan Manuel Carrascal
 * 
 */
public interface CotDAO extends GenericDAO<Cot> {

	public List<Cot> getCotGrilla(Long idEmpresa, String propertySort,
			String orderSort, String propertyFilter[], String valueFilter[],
			Integer min, Integer max) throws DataAccessException;

	public Long getCountCotGrilla(Long idEmpresa)
			throws DataAccessException;
	
	
	
	public Cot getByArchivo(String nombreArchivo);

	
	
}
