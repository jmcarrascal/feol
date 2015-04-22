package jmc.feol.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
//@Table(name="USUARIO", schema = "Feol_Gamma.dbo")
public class Usuario {

private String nombre;
private String organismo;
private String email;
private String oficina;
private String cargo;
private Long idOficina;
private int idPerfil;
private Long idUsuario = 0l;
private String username;
private String password;
private String chequeNr;
private Integer parte;
private Long idEmpresaC;


private Empresa Empresa;

@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "idEmpresa")
public Empresa getEmpresa() {
	return Empresa;
}
public void setEmpresa(Empresa empresa) {
	Empresa = empresa;
}
public Integer getParte() {
	return parte;
}
public void setParte(Integer parte) {
	this.parte = parte;
}
public String getChequeNr() {
	return chequeNr;
}
public void setChequeNr(String chequeNr) {
	this.chequeNr = chequeNr;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Id
public Long getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(Long idUsuario) {
	this.idUsuario = idUsuario;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getOrganismo() {
	return organismo;
}
public void setOrganismo(String organismo) {
	this.organismo = organismo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getOficina() {
	return oficina;
}
public void setOficina(String oficina) {
	this.oficina = oficina;
}
public String getCargo() {
	return cargo;
}
public void setCargo(String cargo) {
	this.cargo = cargo;
}

public int getIdPerfil() {
	return idPerfil;
}
public void setIdPerfil(int idPerfil) {
	this.idPerfil = idPerfil;
}
public Long getIdOficina() {
	return idOficina;
}
public void setIdOficina(Long idOficina) {
	this.idOficina = idOficina;
}
public Long getIdEmpresaC() {
	return idEmpresaC;
}
public void setIdEmpresaC(Long idEmpresaC) {
	this.idEmpresaC = idEmpresaC;
}




}
