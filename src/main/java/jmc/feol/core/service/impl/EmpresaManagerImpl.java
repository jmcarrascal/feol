/*

 * Copyright 2008 Dirección Provincial de Informática de la Provincia de Buenos Aires.  All Rights Reserved

 * Dirección Provincial de Informática de la Provincia de Buenos Aires Proprietary and Confidential.

 *

 * You agree to use Your best efforts to protect the software and documentation

 * from unauthorized copy or use. The software source code represents and embodies

 * trade secrets of Dirección Provincial de Informática de la Provincia de Buenos Aires and/or its licensors.

 * The source code and embodied trade secrets are not licensed to you and any modification,

 * addition or deletion is strictly prohibited. You agree not to disassemble, decompile,

 * or otherwise reverse engineer the software in order to discover the source code and/or

 * the trade secrets contained in the source code.

 *

 *

 * Derecho de autor 2008 Dirección Provincial de Informática de la Provincia de Buenos Aires.  Todos los derechos reservados.

 * Propiedad de Dirección Provincial de Informática de la Provincia de Buenos Aires y Confidencial.

 *

 * Por la presente acuerdo hacer mi mayor esfuerzo para proteger el software y la documentación

 * de la copia o el uso no autorizados. El código fuente del software representa e incluye

 * secretos comerciales de Dirección Provincial de Informática de la Provincia de Buenos Aires y/o sus licenciantes. 

 * No se le otorga licencia del código fuente ni los secretos comerciales incluidos;

 * y cualquier modificación, agregado o eliminación se encuentra estrictamente prohibida.

 * Asimismo, por la presente me comprometo a no desarmar, descompilar, o de alguna forma utilizar

 * técnicas de ingeniería inversa sobre el software para descubrir su fuente y/o los

 * secretos comerciales contenidos en el código fuente.

 *

 */

package jmc.feol.core.service.impl;


import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import jmc.feol.core.service.EmpresaManager;
import jmc.feol.core.dao.GenericDAO;
import jmc.feol.core.model.Empresa;

import org.springframework.dao.DataAccessException;

/**
 * @author clarisa
 *
 */
public class EmpresaManagerImpl implements EmpresaManager{

	private GenericDAO<Empresa> empresaDAO;
	
	public GenericDAO<Empresa> getEmpresaDAO() {
		return empresaDAO;
	}
	public void setEmpresaDAO(GenericDAO<Empresa> empresaDAO) {
		this.empresaDAO = empresaDAO;
	}
	
	public void updateEmpresa(Empresa empresa) throws DataAccessException {
		try{
		Timestamp today = new Timestamp(System.currentTimeMillis());
		empresa.setLastToken(today);
		empresaDAO.update(empresa);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}

	public void saveEmpresa(Empresa empresa) throws DataAccessException{
		empresaDAO.save(empresa);		
	}
	
	public Empresa getByPrimaryKey(Long idEmpresa) throws DataAccessException{
		return empresaDAO.getByPrimaryKey(idEmpresa);
	}
	
	public List<Empresa> getAll()throws DataAccessException{
		HashMap<String , Object> parameters=new HashMap<String, Object>();
		parameters.put("idEmpresaPadre", 1);		
		List<Empresa> empresas = empresaDAO.findByObjectCriteria(parameters);
		return empresas;
	}
	
	public List<Empresa> getAllEmpresasClientes()throws DataAccessException{
		HashMap<String , Object> parameters=new HashMap<String, Object>();
		parameters.put("idEmpresaPadre", 1);		
		List<Empresa> empresas = empresaDAO.findByObjectCriteria(parameters);
		for (Iterator iter = empresas.iterator(); iter.hasNext();) {
			Empresa empresa = (Empresa) iter.next();
			if (empresa.getIdEmpresa().intValue() == 1){
				empresas.remove(empresa);
			}
		}
		return empresas;
	}
	
	public Empresa getByLetra(String letra) throws DataAccessException {
		HashMap<String , Object> parameters=new HashMap<String, Object>();
		parameters.put("letra", letra);		
		List<Empresa> empresas = empresaDAO.findByObjectCriteria(parameters);
		if (empresas.size() > 0){
			return empresas.get(0);
		}else{
			return null;
		}
	}
	
}
