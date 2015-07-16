

package jmc.feol.core.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase modela las oficinas 
 * @author Juan Manuel Carrascal
 *
 */

@Entity
//@Table(name="EMPRESAC" )
@Table(name="EMPRESAC" )
public class EmpresaC {
	
	private Long idEmpresaC;
	private String razonSocial;
	private Long viajeInicio;
	private String baseViajes;
	private Long cuitCot;
	private String baseComun;
	private String baseStock;
	private String calle;
	private String numero;
	private String localidad;
	private String pass;
	private String ipserverBase;
	
	@Id
	public Long getIdEmpresaC() {
		return idEmpresaC;
	}
	public void setIdEmpresaC(Long idEmpresaC) {
		this.idEmpresaC = idEmpresaC;
	}
	
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public Long getViajeInicio() {
		return viajeInicio;
	}
	public void setViajeInicio(Long viajeInicio) {
		this.viajeInicio = viajeInicio;
	}
	public String getBaseViajes() {
		return baseViajes;
	}
	public void setBaseViajes(String baseViajes) {
		this.baseViajes = baseViajes;
	}
	public Long getCuitCot() {
		return cuitCot;
	}
	public void setCuitCot(Long cuitCot) {
		this.cuitCot = cuitCot;
	}
	public String getBaseComun() {
		return baseComun;
	}
	public void setBaseComun(String baseComun) {
		this.baseComun = baseComun;
	}
	public String getBaseStock() {
		return baseStock;
	}
	public void setBaseStock(String baseStock) {
		this.baseStock = baseStock;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getIpserverBase() {
		return ipserverBase;
	}
	public void setIpserverBase(String ipserverBase) {
		this.ipserverBase = ipserverBase;
	}
	
	

}
