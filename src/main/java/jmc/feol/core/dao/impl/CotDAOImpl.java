package jmc.feol.core.dao.impl;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jmc.feol.core.dao.CotDAO;
import jmc.feol.core.model.Cot;
import jmc.feol.core.model.Factura;
import jmc.feol.util.GenerateHqlFilterAndSort;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;



/**     
 * @author       
 *
 */
public class CotDAOImpl extends GenericDAOImpl<Cot> implements CotDAO{

	public CotDAOImpl() {
		super(Cot.class);
		
	}

	@SuppressWarnings("unchecked")
	public List<Cot> getCotGrilla(Long idEmpresa, String propertySort, String orderSort, String propertyFilter[], String valueFilter[], Integer min, Integer max)throws DataAccessException{		
		final Integer minSize = min;
		final Integer maxSize = max;
		List<Cot> cotList = new ArrayList<Cot>();
			try{
				final String queryst = "select fa from Cot fa " + GenerateHqlFilterAndSort.getHqlFilterAndSort("Cot",propertySort,orderSort,"fa",propertyFilter,"fa",valueFilter,true); 				
				cotList = getHibernateTemplate().executeFind((new HibernateCallback() {
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
		return cotList;
	}

	public Long getCountCotGrilla(Long idEmpresa)throws DataAccessException{		
		Long result = 0l;
		try{
			String query = "select count(fa.idCot) from Cot fa "; 								
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

	
	
	
	public Cot getByArchivo(String nombreArchivo){
		Cot cot = null; 
		try{
			String query ="Select cot from Cot cot where cot.nombreArchivo='" + nombreArchivo + "'";
 								
			List<Cot> results = getHibernateTemplate().find(query);
			if (results.size() == 0)
				cot = null;
			else
				cot = results.get(0);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			}
		return cot;
	}


	
 
}
