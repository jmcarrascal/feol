package jmc.feol.core.service;


import jmc.feol.core.model.Empresa;

/**
 * 
 * @author Juan Manuel Carrascal.
 */
public interface CredencialAfipManager{

	public Empresa getCredencial(Empresa empresa) throws Exception;

	}
