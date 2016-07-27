package com.asp.operaciones.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the cof_bitacora database table.
 * 
 */
@Embeddable
public class CofBitacoraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="folio_operacion")
	private String folioOperacion;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	public CofBitacoraPK() {
	}
	public String getFolioOperacion() {
		return this.folioOperacion;
	}
	public void setFolioOperacion(String folioOperacion) {
		this.folioOperacion = folioOperacion;
	}
	public java.util.Date getFecha() {
		return this.fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CofBitacoraPK)) {
			return false;
		}
		CofBitacoraPK castOther = (CofBitacoraPK)other;
		return 
			this.folioOperacion.equals(castOther.folioOperacion)
			&& this.fecha.equals(castOther.fecha);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.folioOperacion.hashCode();
		hash = hash * prime + this.fecha.hashCode();
		
		return hash;
	}
}