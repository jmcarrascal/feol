/**
 * 
 */
package jmc.feol.core.dao.impl;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;


import jmc.feol.core.dao.PatenteDAO;

import jmc.feol.core.model.Patente;



/**     
 * @author       
 *
 */
public class PatenteDAOImpl extends GenericDAOImpl<Patente> implements PatenteDAO{

	public PatenteDAOImpl() {
		super(Patente.class);		
	}

	public List<Patente> getAllOrder() throws DataAccessException {
		List<Patente> patenteList = new ArrayList<Patente>();
		try{
			final String queryst = "select p from Patente p order by orden desc"; 			
			patenteList = getHibernateTemplate().executeFind((new HibernateCallback() {
                public Object doInHibernate(Session session) throws HibernateException, SQLException {
                    Query query = session.createQuery(queryst);
                    return query.list();
                }
            }));
			
	}catch (DataAccessException e) {
		e.printStackTrace();
		
	}
	return patenteList;
	}
 
}
