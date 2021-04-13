package jmc.feol.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "TBCOMPROBANTE")
public class RespuestaAfip {
/**
 *  <cuitEmpresa>30663753025</cuitEmpresa>
  <numeroComprobante>84329999</numeroComprobante>
  <nombreArchivo>TB_30663753025_001001_20121220_044901.txt</nombreArchivo>
  <codigoIntegridad>5ba574f61fc304aefec3999d841292d5</codigoIntegridad>
  <validacionesRemitos class="list">
    <remito>
      <numeroUnico>91 R000100093248</numeroUnico>
      <procesado>NO</procesado>
      <errores class="list">
        <error>
          <codigo>95</codigo>
          <descripcion>El campo IMPORTE es inv�lido o inexistente.</descripcion>
        </error>
      </errores>
    </remito>
    <remito>
      <numeroUnico>91 R000100093247</numeroUnico>
      <procesado>NO</procesado>
      <errores class="list">
        <error>
          <codigo>95</codigo>
          <descripcion>El campo IMPORTE es inv�lido o inexistente.</descripcion>
        </error>
      </errores>
    </remito>
  </validacionesRemitos>
 */
	private String cuitEmpresa;
	private String numeroComprobante;
	private String nombreArchivo;
	private String codigoIntegridad;
	private ValidacionesRemitos validacionesRemitos = new ValidacionesRemitos();
	
	
	
	public String getCuitEmpresa() {
		return cuitEmpresa;
	}



	public void setCuitEmpresa(String cuitEmpresa) {
		this.cuitEmpresa = cuitEmpresa;
	}



	public String getNumeroComprobante() {
		return numeroComprobante;
	}



	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}



	public String getNombreArchivo() {
		return nombreArchivo;
	}



	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}



	public String getCodigoIntegridad() {
		return codigoIntegridad;
	}



	public void setCodigoIntegridad(String codigoIntegridad) {
		this.codigoIntegridad = codigoIntegridad;
	}









	public ValidacionesRemitos getValidacionesRemitos() {
		return validacionesRemitos;
	}



	public void setValidacionesRemitos(ValidacionesRemitos validacionesRemitos) {
		this.validacionesRemitos = validacionesRemitos;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
