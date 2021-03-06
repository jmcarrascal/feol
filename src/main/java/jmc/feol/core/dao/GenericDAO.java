package jmc.feol.core.dao;




import java.util.HashMap;
import java.util.List;


import org.springframework.dao.DataAccessException;

public interface GenericDAO<T> {

	public void save(T newInstance)throws DataAccessException;
	
	public void update(T persistenceInstance)throws DataAccessException;
	
	public void remove(T persistenceInstance)throws DataAccessException;
	
	public List<T> getAll()throws DataAccessException ;
	
	public T getByPrimaryKey(Long id)throws DataAccessException ;
	
	public T getByPrimaryKey(Integer id)throws DataAccessException ;
	
	public List<T> findByObjectCriteria(T object)throws DataAccessException;
	
	public List<T> findByObjectCriteria(HashMap<String, Object> res)throws DataAccessException;

	public void removeAll(List<T> objects)throws DataAccessException ;

	public void saveOrUpdateAll(List<T> objects)throws DataAccessException ;
	//public List<T> getByCriterio(DetachedCriteria criteria);
	
	public List<T> getListbyQuery(String query) throws DataAccessException;

}
