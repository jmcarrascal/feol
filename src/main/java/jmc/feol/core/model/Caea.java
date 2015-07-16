package jmc.feol.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="CAEA")
public class Caea {
	
	
	private Long idCaea;
	
	 	private java.lang.String CAEA;

	    private Integer periodo;

	    private Integer orden;

	    private java.lang.String fchVigDesde;

	    private java.lang.String fchVigHasta;

	    private java.lang.String fchTopeInf;

	    private java.lang.String fchProceso;
	    
		
	    private Empresa empresa;

		public java.lang.String getCAEA() {
			return CAEA;
		}

		public void setCAEA(java.lang.String cAEA) {
			CAEA = cAEA;
		}

		public Integer getPeriodo() {
			return periodo;
		}

		public void setPeriodo(Integer periodo) {
			this.periodo = periodo;
		}

		public Integer getOrden() {
			return orden;
		}

		public void setOrden(Integer orden) {
			this.orden = orden;
		}

		public java.lang.String getFchVigDesde() {
			return fchVigDesde;
		}

		public void setFchVigDesde(java.lang.String fchVigDesde) {
			this.fchVigDesde = fchVigDesde;
		}

		public java.lang.String getFchVigHasta() {
			return fchVigHasta;
		}

		public void setFchVigHasta(java.lang.String fchVigHasta) {
			this.fchVigHasta = fchVigHasta;
		}

		public java.lang.String getFchTopeInf() {
			return fchTopeInf;
		}

		public void setFchTopeInf(java.lang.String fchTopeInf) {
			this.fchTopeInf = fchTopeInf;
		}

		public java.lang.String getFchProceso() {
			return fchProceso;
		}

		public void setFchProceso(java.lang.String fchProceso) {
			this.fchProceso = fchProceso;
		}
		
		@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "idEmpresa")
		public Empresa getEmpresa() {
			return empresa;
		}

		public void setEmpresa(Empresa empresa) {
			this.empresa = empresa;
		}
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)		
		public Long getIdCaea() {
			return idCaea;
		}

		public void setIdCaea(Long idCaea) {
			this.idCaea = idCaea;
		}
		
		
	    
	    
	    

}
