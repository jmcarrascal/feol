

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
@Table(name="EMPRESA" )
//@Table(name="EMPRESA" , schema = "Feol_Gamma.dbo")
public class Empresa {

	private Long idEmpresa;
	private String nombre;
	private String cuit;
	private String token;
	private String signToken;
	private Timestamp lastToken; 
	private String rutaArchivoConfigAfip;
	private String rutaLecturaArchivoFactura;
	private String rutaArchivoDefinitivo;
	private String ingresosBrutos;
	private String inicioActividades;
	private String urlWebService;
	private String endpoint;
	private String service;
	private String dstDN;
	private String p12File;
	private String signer;
	private String p12pass;
	private Long ticketTime;
	private Integer punto_vta;
	private Long idEmpresaPadre;
	private String letra;
	private String libAS400;
	
	
	
	
	
	public String getLibAS400() {
		return libAS400;
	}
	public void setLibAS400(String libAS400) {
		this.libAS400 = libAS400;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getInicioActividad() {
		return inicioActividad;
	}
	public void setInicioActividad(String inicioActividad) {
		this.inicioActividad = inicioActividad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	private String provincia;
	private String codigoPostal;
	private String localidad;
	private String direccion;
	private String inicioActividad;
	private String telefono;
	
	
	
	
	
	

	

	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Long getIdEmpresaPadre() {
		return idEmpresaPadre;
	}
	public void setIdEmpresaPadre(Long idEmpresaPadre) {
		this.idEmpresaPadre = idEmpresaPadre;
	}
	public Integer getPunto_vta() {
		return punto_vta;
	}
	public void setPunto_vta(Integer punto_vta) {
		this.punto_vta = punto_vta;
	}
	public String getUrlWebService() {
		return urlWebService;
	}
	public void setUrlWebService(String urlWebService) {
		this.urlWebService = urlWebService;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getSignToken() {
		return signToken;
	}
	public void setSignToken(String signToken) {
		this.signToken = signToken;
	}
	
	public Timestamp getLastToken() {
		return lastToken;
	}
	public void setLastToken(Timestamp lastToken) {
		this.lastToken = lastToken;
	}
	public String getRutaArchivoConfigAfip() {
		return rutaArchivoConfigAfip;
	}
	public void setRutaArchivoConfigAfip(String rutaArchivoConfigAfip) {
		this.rutaArchivoConfigAfip = rutaArchivoConfigAfip;
	}
	public String getRutaLecturaArchivoFactura() {
		return rutaLecturaArchivoFactura;
	}
	public void setRutaLecturaArchivoFactura(String rutaLecturaArchivoFactura) {
		this.rutaLecturaArchivoFactura = rutaLecturaArchivoFactura;
	}
	public String getRutaArchivoDefinitivo() {
		return rutaArchivoDefinitivo;
	}
	public void setRutaArchivoDefinitivo(String rutaArchivoDefinitivo) {
		this.rutaArchivoDefinitivo = rutaArchivoDefinitivo;
	}
	public String getIngresosBrutos() {
		return ingresosBrutos;
	}
	public void setIngresosBrutos(String ingresosBrutos) {
		this.ingresosBrutos = ingresosBrutos;
	}
	public String getInicioActividades() {
		return inicioActividades;
	}
	public void setInicioActividades(String inicioActividades) {
		this.inicioActividades = inicioActividades;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getDstDN() {
		return dstDN;
	}
	public void setDstDN(String dstDN) {
		this.dstDN = dstDN;
	}
	public String getP12File() {
		return p12File;
	}
	public void setP12File(String p12File) {
		this.p12File = p12File;
	}
	public String getP12pass() {
		return p12pass;
	}
	public void setP12pass(String p12pass) {
		this.p12pass = p12pass;
	}
	public Long getTicketTime() {
		return ticketTime;
	}
	public void setTicketTime(Long ticketTime) {
		this.ticketTime = ticketTime;
	}
	public String getSigner() {
		return signer;
	}
	public void setSigner(String signer) {
		this.signer = signer;
	}	
	
	
}
