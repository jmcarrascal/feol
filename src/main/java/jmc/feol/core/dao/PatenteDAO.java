/**
 * 
 */
package jmc.feol.core.dao;

import java.util.List;

import jmc.feol.core.model.Factura;
import jmc.feol.core.model.Patente;

import org.springframework.dao.DataAccessException;

/**
 * @author Juan Manuel Carrascal
 * 
 */
public interface PatenteDAO extends GenericDAO<Patente> {

	public List<Patente> getAllOrder() throws DataAccessException;

}
