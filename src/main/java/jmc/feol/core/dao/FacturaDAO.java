/**
 * 
 */
package jmc.feol.core.dao;

import java.util.List;

import jmc.feol.core.model.Factura;

import org.springframework.dao.DataAccessException;

/**
 * @author Juan Manuel Carrascal
 * 
 */
public interface FacturaDAO extends GenericDAO<Factura> {

	public List<Factura> getFacturaGrilla(Long idEmpresa, String propertySort,
			String orderSort, String propertyFilter[], String valueFilter[],
			Integer min, Integer max) throws DataAccessException;

	public Long getCountFacturaGrilla(Long idEmpresa)
			throws DataAccessException;
	
	public Factura getByFactura(Factura facturaIn);
	
	public Factura getByArchivo(String nombreArchivo);

	public List<Factura> getFacturasPerdidas(String fechadesde)throws DataAccessException;

	public String getByPKAfip(Integer prefijo, Integer comprobanteTipo,
			Long nroComprobante);

	public List<Factura> getFacturasConError();
}
