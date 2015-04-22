package jmc.feol.core.service;


import java.util.List;

import jmc.feol.core.model.Factura;

/**
 * Interfaz de acceso a los servicios referentes a Remitos
 * @author Juan Manuel Carrascal
 */
public interface FacturasManager 
{
	
	public List<Factura> getFacturaGrilla(String propertySort, String orderSort, String[] propertyFilter, String[] valueFilter, Integer min,  Integer max) throws Exception;

	public void reProcesarFactura(String nombreArchivo);
	
	public Long getCountFacturaGrilla();

	public List<String> getFacturasOrdenadas();

	public void reProcesarFactura(Factura facturaActual);

	
}
