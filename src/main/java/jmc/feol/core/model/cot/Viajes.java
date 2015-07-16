package jmc.feol.core.model.cot;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;

/**
 * Viajes generated by hbm2java
 */
@Entity
@Table(name = "Viajes",  schema = "Empresa4.dbo")
public class Viajes implements java.io.Serializable {

	private Integer viajeNr;
	private Date fecha;
	private Integer choferNr;
	private Integer zonaNr;
	private Float km;
	private BigDecimal precio;
	private Integer modalidad;
	private String obser;
	private BigDecimal valoriz;
	private Integer viajeChof;
	private Set detaViajeses = new HashSet(0);
	private boolean procesado = false;
	
	

	@Transient
	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}

	public Viajes() {
	}

	public Viajes(int viajeNr) {
		this.viajeNr = viajeNr;
	}

	public Viajes(Integer viajeNr, Date fecha, Integer choferNr, Integer zonaNr,
			Float km, BigDecimal precio, Integer modalidad, String obser,
			BigDecimal valoriz, Integer viajeChof, Set detaViajeses) {
		this.viajeNr = viajeNr;
		this.fecha = fecha;
		this.choferNr = choferNr;
		this.zonaNr = zonaNr;
		this.km = km;
		this.precio = precio;
		this.modalidad = modalidad;
		this.obser = obser;
		this.valoriz = valoriz;
		this.viajeChof = viajeChof;
		this.detaViajeses = detaViajeses;
	}

	@Id
	@Column(name = "ViajeNr", unique = true, nullable = true)
	public Integer getViajeNr() {
		return this.viajeNr;
	}

	public void setViajeNr(Integer viajeNr) {
		this.viajeNr = viajeNr;
	}

	@Column(name = "Fecha", length = 16)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "ChoferNr")
	public Integer getChoferNr() {
		return this.choferNr;
	}

	public void setChoferNr(Integer choferNr) {
		this.choferNr = choferNr;
	}

	@Column(name = "ZonaNr")
	public Integer getZonaNr() {
		return this.zonaNr;
	}

	public void setZonaNr(Integer zonaNr) {
		this.zonaNr = zonaNr;
	}

	@Column(name = "Km", precision = 24, scale = 0)
	public Float getKm() {
		return this.km;
	}

	public void setKm(Float km) {
		this.km = km;
	}

	@Column(name = "Precio", scale = 4)
	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Column(name = "Modalidad")
	public Integer getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(Integer modalidad) {
		this.modalidad = modalidad;
	}

	@Column(name = "Obser", length = 250)
	public String getObser() {
		return this.obser;
	}

	public void setObser(String obser) {
		this.obser = obser;
	}

	@Column(name = "Valoriz", scale = 4)
	public BigDecimal getValoriz() {
		return this.valoriz;
	}

	public void setValoriz(BigDecimal valoriz) {
		this.valoriz = valoriz;
	}

	@Column(name = "ViajeChof")
	public Integer getViajeChof() {
		return this.viajeChof;
	}

	public void setViajeChof(Integer viajeChof) {
		this.viajeChof = viajeChof;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "viajes")
	public Set getDetaViajeses() {
		return this.detaViajeses;
	}

	public void setDetaViajeses(Set detaViajeses) {
		this.detaViajeses = detaViajeses;
	}

}
