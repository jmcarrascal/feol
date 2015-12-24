package jmc.feol.core.dao.impl;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;


import jmc.feol.core.dao.FacturaDAO;
import jmc.feol.core.model.Factura;
import jmc.feol.util.GenerateHqlFilterAndSort;



/**     
 * @author       
 *
 */
public class FacturaDAOImpl extends GenericDAOImpl<Factura> implements FacturaDAO{

	public FacturaDAOImpl() {
		super(Factura.class);		
	}

	@SuppressWarnings("unchecked")
	public List<Factura> getFacturaGrilla(Long idEmpresa, String propertySort, String orderSort, String propertyFilter[], String valueFilter[], Integer min, Integer max)throws DataAccessException{		
		final Integer minSize = min;
		final Integer maxSize = max;
		List<Factura> facturaList = new ArrayList<Factura>();
			try{
				final String queryst = "select fa from Factura fa " + GenerateHqlFilterAndSort.getHqlFilterAndSort("Factura",propertySort,orderSort,"fa",propertyFilter,"fa",valueFilter,true); 				
				facturaList = getHibernateTemplate().executeFind((new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException, SQLException {
                        Query query = session.createQuery(queryst);
                        //query.setFetchSize(15);
                        query.setMaxResults(maxSize.intValue());
                        query.setFirstResult(minSize.intValue());
                        return query.list();
                    }
                }));
				
		}catch (DataAccessException e) {
			e.printStackTrace();
			
		}
		return facturaList;
	}

	public Long getCountFacturaGrilla(Long idEmpresa)throws DataAccessException{		
		Long result = 0l;
		try{
			String query = "select count(fa.idFactura) from Factura fa "; 								
			List<Long> results = getHibernateTemplate().find(query);
			if (results.size() == 0)
				result = 0l;
			else
				result = results.get(0);
				
	}catch (DataAccessException e) {
		e.printStackTrace();
		
	}
	return result;		
	}

	public Factura getByFactura(Factura facturaIn){
		Factura factura = null; 
		try{
			String query ="Select factura from Factura factura where factura.tipo_cbte =" +
 			" " + facturaIn.getTipo_cbte() + " and  factura.punto_vta = " + facturaIn.getPunto_vta() + " and  factura.cbt_desde = " + facturaIn.getCbt_desde();
 								
			List<Factura> results = getHibernateTemplate().find(query);
			if (results.size() == 0)
				factura = null;
			else
				factura = results.get(0);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			}
		return factura; 
	}
	
	public List<Factura> getFacturasConError(){
		List<Factura> facturas = null;  
		//System.out.println("Inicio facturas");
		try{
			String query ="select factura from Factura factura where factura.codError = 10 order by punto_vta,tipo_cbte,cbt_desde";
			facturas = getHibernateTemplate().find(query);
			//System.out.println("Se encontrarton :" + facturas.size() + " para procesar por problemas de internet");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			}
		return facturas;
	}

	public Factura getByArchivo(String nombreArchivo){
		Factura factura = null; 
		try{
			String query ="Select factura from Factura factura where factura.nombreArchivo='" + nombreArchivo + "'";
 								
			List<Factura> results = getHibernateTemplate().find(query);
			if (results.size() == 0)
				factura = null;
			else
				factura = results.get(0);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			}
		return factura;
	}


	public List<Factura> getFacturasPerdidas(String fechadesde)throws DataAccessException{		
		List<Factura> facturaList = new ArrayList<Factura>();
			try{
				final String queryst = "select fa from Factura fa where fa.cbt_desde is not null and fecha_cbte > '"+fechadesde+" 00:00:00' order by tipo_cbte, punto_vta, cbt_desde "; 
				facturaList = getHibernateTemplate().executeFind((new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException, SQLException {
                        Query query = session.createQuery(queryst);
                        return query.list();
                    }
                }));
				
		}catch (DataAccessException e) {
			e.printStackTrace();
			
		}
		return facturaList;
	}

	
	public String getByPKAfip(Integer prefijo, Integer comprobanteTipo,
			Long nroComprobante) {
		List<Factura> facturaList = new ArrayList<Factura>();
		try{
			final String queryst = "select fa from Factura fa where fa.cbt_desde = " + nroComprobante + " and fa.punto_vta = " + prefijo + " and fa.tipo_cbte = " + comprobanteTipo ; 
			facturaList = getHibernateTemplate().executeFind((new HibernateCallback() {
                public Object doInHibernate(Session session) throws HibernateException, SQLException {
                    Query query = session.createQuery(queryst);
                    return query.list();
                }
            }));
			
	}catch (DataAccessException e) {
		e.printStackTrace();
		
	}
	String result = "";
	try{
		result = facturaList.get(0).getNumeroInterno();
	}catch(Exception e){
		System.out.println("No se encontro la factura "+ nroComprobante);
	}
	
	return result;


	}
 
}
