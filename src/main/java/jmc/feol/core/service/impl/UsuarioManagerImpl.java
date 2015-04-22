package jmc.feol.core.service.impl;

import java.util.HashMap;
import java.util.List;

import jmc.feol.core.service.UsuarioManager;
import jmc.feol.core.dao.GenericDAO;
import jmc.feol.core.model.Usuario;




/**
 * @author Juan Manuel Carrascal
 *
 */
public class UsuarioManagerImpl implements UsuarioManager{

	private GenericDAO<Usuario> usuarioDAO;

	public GenericDAO<Usuario> getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(GenericDAO<Usuario> usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	public Usuario getUsuarioByUsernamePassword(String username, String password){
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("username", username.trim());
		res.put("password", password.trim());
		List<Usuario> usuarios = usuarioDAO.findByObjectCriteria(res);
		//List<Usuario> usuarios = usuarioDAO.getAll();
		if (usuarios.size()>0){
			Usuario usuario = usuarios.get(0);			
			return usuario;			
		}else{
			return null;
		}
	}
	
	public void addUsuario(Usuario usuario){
		usuarioDAO.save(usuario);
	}
	
	public Usuario getUsuarioByPk(Long idUsuario){
		return usuarioDAO.getByPrimaryKey(idUsuario);
	}

	@Override
	public void changePasswordMdaemon(String userName, String oldPassword,
			String newPassword1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePasswordDB(Long idOperador, String newPassword1) {
		// TODO Auto-generated method stub
		
	}

	
}
