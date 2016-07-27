package com.asp.operaciones.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the cof_bitacora database table.
 * 
 */
@Entity
@Table(name="cof_bitacora")
@NamedQuery(name="CofBitacora.findAll", query="SELECT c FROM CofBitacora c")
public class CofBitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CofBitacoraPK id;

	private String error;

	@Column(name="status_operacion")
	private Integer statusOperacion;

	@Column(name="usuario_informado")
	private String usuarioInformado;

	@Column(name="usuario_operacion")
	private String usuarioOperacion;

	//bi-directional many-to-one association to CofOperacione
	@ManyToOne
	@JoinColumn(name="clave_operacion")
	private CofOperacione cofOperacione;

	public CofBitacora() {
	}

	public CofBitacoraPK getId() {
		return this.id;
	}

	public void setId(CofBitacoraPK id) {
		this.id = id;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getStatusOperacion() {
		return this.statusOperacion;
	}

	public void setStatusOperacion(Integer statusOperacion) {
		this.statusOperacion = statusOperacion;
	}

	public String getUsuarioInformado() {
		return this.usuarioInformado;
	}

	public void setUsuarioInformado(String usuarioInformado) {
		this.usuarioInformado = usuarioInformado;
	}

	public String getUsuarioOperacion() {
		return this.usuarioOperacion;
	}

	public void setUsuarioOperacion(String usuarioOperacion) {
		this.usuarioOperacion = usuarioOperacion;
	}

	public CofOperacione getCofOperacione() {
		return this.cofOperacione;
	}

	public void setCofOperacione(CofOperacione cofOperacione) {
		this.cofOperacione = cofOperacione;
	}

}