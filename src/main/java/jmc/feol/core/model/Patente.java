/*

 * Copyright 2008 Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires.  All Rights Reserved

 * Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires Proprietary and Confidential.

 *

 * You agree to use Your best efforts to protect the software and documentation

 * from unauthorized copy or use. The software source code represents and embodies

 * trade secrets of Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires and/or its licensors.

 * The source code and embodied trade secrets are not licensed to you and any modification,

 * addition or deletion is strictly prohibited. You agree not to disassemble, decompile,

 * or otherwise reverse engineer the software in order to discover the source code and/or

 * the trade secrets contained in the source code.

 *

 *

 * Derecho de autor 2008 Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires.  Todos los derechos reservados.

 * Propiedad de Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires y Confidencial.

 *

 * Por la presente acuerdo hacer mi mayor esfuerzo para proteger el software y la documentaci�n

 * de la copia o el uso no autorizados. El c�digo fuente del software representa e incluye

 * secretos comerciales de Direcci�n Provincial de Inform�tica de la Provincia de Buenos Aires y/o sus licenciantes. 

 * No se le otorga licencia del c�digo fuente ni los secretos comerciales incluidos;

 * y cualquier modificaci�n, agregado o eliminaci�n se encuentra estrictamente prohibida.

 * Asimismo, por la presente me comprometo a no desarmar, descompilar, o de alguna forma utilizar

 * t�cnicas de ingenier�a inversa sobre el software para descubrir su fuente y/o los

 * secretos comerciales contenidos en el c�digo fuente.

 *

 */
package jmc.feol.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Esta clase modela los anexos asociados a cada documento
 * @author Juan Manuel Carrascal
 *
 */

/**
 * @author Juan Manuel
 *
 */
@Entity
//@Table(name="PARAMETRIZACION", schema = "Herramientas.dbo")
@Table(name="PATENTES")
public class Patente {

	private Long idPatente;
	private String descrip;
	private String valor;
	private int orden;
	private String descripC;
	
	
	@Transient
	public String getDescripC() {
		descripC = "[" + valor + "] " + descrip;
		return descripC;
	}
	public void setDescripC(String descripC) {
		this.descripC = descripC;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdPatente() {
		return idPatente;
	}
	public void setIdPatente(Long idPatente) {
		this.idPatente = idPatente;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}

	
}
