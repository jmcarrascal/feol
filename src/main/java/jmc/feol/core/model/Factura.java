
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
//@Table(name="FACTURA" , schema = "Feol_Gamma.dbo")
@Table(name="FACTURA")
public class Factura {
    
	private Long idFactura;
		
	/*
     * Datos de Cabecera de la Factura
     */
	private Long id;
    private Integer cantidadreg;
    private Integer presta_serv;
    private String idAfip;
    /*
     * Datos del Detalle de la Factura
     */
	private Integer tipo_doc;
    private Long nro_doc;
    private Integer tipo_cbte;
    private Integer punto_vta;
    private Long cbt_desde;
    private Long cbt_hasta;
    private Double imp_total;
    private Double imp_tot_conc;
    private Double imp_neto;
    private Double impto_liq;
    private Double impto_liq_rni;
    private Double imp_op_ex;
    private Timestamp fecha_cbte;
    private Timestamp fecha_serv_desde;
    private Timestamp fecha_serv_hasta;
    private Timestamp fecha_creacion;
    private Timestamp fecha_venc_pago;
    private String formaPago;
    private Boolean tieneCae;
    private String tipoFactura;
    private String codError;
    private String numeroInterno;
    private byte[] adjunto;
    private String rutaComun;
    private String rutaArticulo;
    private byte[] requestEnviado;
    private String letra;
    private String errorCAE = "";
    private String metodoAfip;
    
    
    
    
    public String getMetodoAfip() {
		return metodoAfip;
	}
	public void setMetodoAfip(String metodoAfip) {
		this.metodoAfip = metodoAfip;
	}
	public String getErrorCAE() {
		return errorCAE;
	}
	public void setErrorCAE(String errorCAE) {
		this.errorCAE = errorCAE;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	@Column(length=8000)
    public byte[] getRequestEnviado() {
		return requestEnviado;
	}
	public void setRequestEnviado(byte[] requestEnviado) {
		this.requestEnviado = requestEnviado;
	}
	public String getRutaComun() {
		return rutaComun;
	}
	public void setRutaComun(String rutaComun) {
		this.rutaComun = rutaComun;
	}
	public String getRutaArticulo() {
		return rutaArticulo;
	}
	public void setRutaArticulo(String rutaArticulo) {
		this.rutaArticulo = rutaArticulo;
	}
	/*
     * Datos adicionales de auditoria
     */
    private String fechaUpdate;
	/*
	 * Datos de Respuesta de AFIP
	 */
    private String cae;
    private String cae_vto;
    private String resultado;
    private Integer motivo;
    
    private String observaciones;
    private String nombreArchivo = ""; 
    private String reproceso;
    /*
     * Datos de detalle de la Factura
     */
    
	@Id
	//Solo Para Simpa
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//Generico para todos
	@GeneratedValue(strategy=GenerationType.AUTO)	    
	public Long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCantidadreg() {
		return cantidadreg;
	}
	public void setCantidadreg(Integer cantidadreg) {
		this.cantidadreg = cantidadreg;
	}
	public Integer getPresta_serv() {
		return presta_serv;
	}
	public void setPresta_serv(Integer presta_serv) {
		this.presta_serv = presta_serv;
	}
	public Integer getTipo_doc() {
		return tipo_doc;
	}
	public void setTipo_doc(Integer tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	public Long getNro_doc() {
		return nro_doc;
	}
	public void setNro_doc(Long nro_doc) {
		this.nro_doc = nro_doc;
	}
	public Integer getTipo_cbte() {
		return tipo_cbte;
	}
	public void setTipo_cbte(Integer tipo_cbte) {
		this.tipo_cbte = tipo_cbte;
	}
	public Integer getPunto_vta() {
		return punto_vta;
	}
	public void setPunto_vta(Integer punto_vta) {
		this.punto_vta = punto_vta;
	}
	public Long getCbt_desde() {
		return cbt_desde;
	}
	public void setCbt_desde(Long cbt_desde) {
		this.cbt_desde = cbt_desde;
	}
	public Long getCbt_hasta() {
		return cbt_hasta;
	}
	public void setCbt_hasta(Long cbt_hasta) {
		this.cbt_hasta = cbt_hasta;
	}
	public Double getImp_total() {
		return imp_total;
	}
	public void setImp_total(Double imp_total) {
		this.imp_total = imp_total;
	}
	public Double getImp_tot_conc() {
		return imp_tot_conc;
	}
	public void setImp_tot_conc(Double imp_tot_conc) {
		this.imp_tot_conc = imp_tot_conc;
	}
	public Double getImp_neto() {
		return imp_neto;
	}
	public void setImp_neto(Double imp_neto) {
		this.imp_neto = imp_neto;
	}
	public Double getImpto_liq() {
		return impto_liq;
	}
	public void setImpto_liq(Double impto_liq) {
		this.impto_liq = impto_liq;
	}
	public Double getImpto_liq_rni() {
		return impto_liq_rni;
	}
	public void setImpto_liq_rni(Double impto_liq_rni) {
		this.impto_liq_rni = impto_liq_rni;
	}
	public Double getImp_op_ex() {
		return imp_op_ex;
	}
	public void setImp_op_ex(Double imp_op_ex) {
		this.imp_op_ex = imp_op_ex;
	}

	public Timestamp getFecha_cbte() {
		return fecha_cbte;
	}
	public void setFecha_cbte(Timestamp fecha_cbte) {
		this.fecha_cbte = fecha_cbte;
	}
	public Timestamp getFecha_serv_desde() {
		return fecha_serv_desde;
	}
	public void setFecha_serv_desde(Timestamp fecha_serv_desde) {
		this.fecha_serv_desde = fecha_serv_desde;
	}
	public Timestamp getFecha_serv_hasta() {
		return fecha_serv_hasta;
	}
	public void setFecha_serv_hasta(Timestamp fecha_serv_hasta) {
		this.fecha_serv_hasta = fecha_serv_hasta;
	}
	public Timestamp getFecha_venc_pago() {
		return fecha_venc_pago;
	}
	public void setFecha_venc_pago(Timestamp fecha_venc_pago) {
		this.fecha_venc_pago = fecha_venc_pago;
	}
	public String getFechaUpdate() {
		return fechaUpdate;
	}
	public void setFechaUpdate(String fechaUpdate) {
		this.fechaUpdate = fechaUpdate;
	}
	public String getCae() {
		return cae;
	}
	public void setCae(String cae) {
		this.cae = cae;
	}
	public String getCae_vto() {
		return cae_vto;
	}
	public void setCae_vto(String cae_vto) {
		this.cae_vto = cae_vto;
	}
	@Column(length=4000)
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Integer getMotivo() {
		return motivo;
	}
	public void setMotivo(Integer motivo) {
		this.motivo = motivo;
	}
	

	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	
	@Column(length=1000)
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Transient	
	public Boolean getTieneCae() {
		if(this.cae != null && !this.cae.equals("NULL")){
			return true;
		}else{
			return false;
		}
	}
	public void setTieneCae(Boolean tieneCae) {
		this.tieneCae = tieneCae;
	}
		
	
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getReproceso() {
		return reproceso;
	}
	public void setReproceso(String reproceso) {
		this.reproceso = reproceso;
	}
	public String getCodError() {
		return codError;
	}
	public void setCodError(String codError) {
		this.codError = codError;
	}
	public String getNumeroInterno() {
		return numeroInterno;
	}
	public void setNumeroInterno(String numeroInterno) {
		this.numeroInterno = numeroInterno;
	}
	public String getIdAfip() {
		return idAfip;
	}
	public void setIdAfip(String idAfip) {
		this.idAfip = idAfip;
	}
	
	@Lob @Basic(fetch=FetchType.EAGER)
	public byte[] getAdjunto() {
		return adjunto;
	}
	public void setAdjunto(byte[] adjunto) {
		this.adjunto = adjunto;
	}
	
	
	@Transient	
	public String getTipoFactura() {
		if(tipo_cbte == 1){
			tipoFactura = "FC A";
		}
		if(tipo_cbte == 2){
			tipoFactura = "ND A";
		}
		if(tipo_cbte == 3){
			tipoFactura = "NC A";
		}		
		if(tipo_cbte == 6){
			tipoFactura = "FC B";
		} 
		if(tipo_cbte == 7){
			tipoFactura = "ND B";
		} 
		if(tipo_cbte == 8){
			tipoFactura = "NC B";
		} 
		if(tipo_cbte == 19){
			tipoFactura = "FC E";
		}
		if(tipo_cbte == 20){
			tipoFactura = "ND E";
		}
		if(tipo_cbte == 21){
			tipoFactura = "NC E";
		}		

		return tipoFactura;
	}
		
}
