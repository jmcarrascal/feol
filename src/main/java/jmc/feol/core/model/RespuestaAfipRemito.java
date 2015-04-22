package jmc.feol.core.model;

import java.util.ArrayList;
import java.util.List;

public class RespuestaAfipRemito {
	private String numeroUnico;
	private String procesado;
	private Errores errores = new Errores();
	
	
	
	
	public String getNumeroUnico() {
		return numeroUnico;
	}




	public void setNumeroUnico(String numeroUnico) {
		this.numeroUnico = numeroUnico;
	}




	public String getProcesado() {
		return procesado;
	}




	public void setProcesado(String procesado) {
		this.procesado = procesado;
	}




	




	public Errores getErrores() {
		return errores;
	}




	public void setErrores(Errores errores) {
		this.errores = errores;
	}




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
