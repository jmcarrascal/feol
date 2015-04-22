package jmc.feol.ui.struts.actions;


import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;

import jmc.feol.core.model.Usuario;
import jmc.feol.core.service.ParametrizacionManager;
import jmc.feol.core.service.UsuarioManager;
import jmc.feol.util.Constants;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;





public class LoginAction extends ActionSupport  {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String password;
	private ParametrizacionManager parametrizacionManager;
	private UsuarioManager usuarioManager;
	
	public UsuarioManager getUsuarioManager() {
		return usuarioManager;
	}


	public void setUsuarioManager(UsuarioManager usuarioManager) {
		this.usuarioManager = usuarioManager;
	}


	public ParametrizacionManager getParametrizacionManager() {
		return parametrizacionManager;
	}


	public void setParametrizacionManager(
			ParametrizacionManager parametrizacionManager) {
		this.parametrizacionManager = parametrizacionManager;
	}


	public String execute() throws Exception {
    
    return "success";
	}
  
	/**
	 * Redirige la APP a la pagina de Login 
	 * @return
	 * @throws Exception
	 */
	public String login(){	        
	    return "success";
	}
	
	/**
	 * Cierra la session de la APP y redirige al Login
	 * @return
	 * @throws Exception
	 */
	public String out() throws Exception {	        		
		HttpServletRequest request =(HttpServletRequest)ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		request.getSession().setAttribute("usuario", null);
		return "success";
	}

	
	/*
	 * Metodo que toma los valores usuario y password
	 * y valida contra el WS a validez del mismo contra el Login unico
	 * Se invoca solo para usuarios del Ministerio de Justicia
	 */
	public String validateMS() throws Exception {	    
		Usuario user = null;
		try {
			user = usuarioManager.getUsuarioByUsernamePassword(usuario, password);			
		} catch (Exception e1) {			
			e1.printStackTrace();
			return "exit";
		}
		if (user == null){
			return "failedAuth";
		}else{
			HttpServletRequest request =(HttpServletRequest)ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_REQUEST);

			request.getSession().setAttribute("usuario", user);
			if (user.getIdPerfil() == 1){
				return "ok";
			}
			if (user.getIdPerfil() == 4){
				return "cot";
			}
			return "ok";
			

		}				
	}
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}