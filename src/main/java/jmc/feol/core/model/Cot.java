
 package jmc.feol.core.model;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;

/**
 * 
 * @author Juan Manuel Carrascal
 *
 */

@Entity
@Table(name="COT")
public class Cot {
    
	private Long idCot;			
    private Timestamp fecha_creacion;
    private String nombreArchivo;
    private String planta;
    private String secuencia;
    private String respuesta;
    private String nombreArchivoEntrada;
    
    public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdCot() {
		return idCot;
	}
	public void setIdCot(Long idCot) {
		this.idCot = idCot;
	}
	
	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public String getPlanta() {
		return planta;
	}
	public void setPlanta(String planta) {
		this.planta = planta;
	}
	public String getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}
	public String getNombreArchivoEntrada() {
		return nombreArchivoEntrada;
	}
	public void setNombreArchivoEntrada(String nombreArchivoEntrada) {
		this.nombreArchivoEntrada = nombreArchivoEntrada;
	}
    
    
    
    }
