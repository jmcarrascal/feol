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

package jmc.feol.core.service;


import java.util.List;

import org.springframework.dao.DataAccessException;

import jmc.feol.core.model.Empresa;


/**
 * @author Juan Manuel Carrascal.
 *
 */
public interface EmpresaManager {
	
	public void updateEmpresa(Empresa empresa) throws DataAccessException;
	
	public Empresa getByPrimaryKey(Long idEmpresa) throws DataAccessException;
	
	public List<Empresa> getAllEmpresasClientes()throws DataAccessException;
	
	public void saveEmpresa(Empresa empresa) throws DataAccessException;
	
	public List<Empresa> getAll()throws DataAccessException;

	public Empresa getByLetra(String letra)throws DataAccessException;
	
	
}
