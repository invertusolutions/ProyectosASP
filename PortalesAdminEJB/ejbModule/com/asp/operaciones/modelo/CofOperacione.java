package com.asp.operaciones.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cof_operaciones database table.
 * 
 */
@Entity
@Table(name="cof_operaciones")
@NamedQueries({
	@NamedQuery(name="CofOperacione.findAll", query="SELECT c FROM CofOperacione c"),
	@NamedQuery(name="CofOperacione.findAOP", query = "SELECT c FROM CofOperacione c WHERE c.claveOperacion = :claveOP")
})

public class CofOperacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clave_operacion")
	private String claveOperacion;

	@Column(name="clave_sistema")
	private String claveSistema;

	@Column(name="creado_por")
	private String creadoPor;

	private String descripcion;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	@Column(name="modificado_por")
	private String modificadoPor;

	private String nombre;

	private Integer status;

	//bi-directional many-to-one association to CofBitacora
	@OneToMany(mappedBy="cofOperacione")
	private List<CofBitacora> cofBitacoras;

	public CofOperacione() {
	}

	public String getClaveOperacion() {
		return this.claveOperacion;
	}

	public void setClaveOperacion(String claveOperacion) {
		this.claveOperacion = claveOperacion;
	}

	public String getClaveSistema() {
		return this.claveSistema;
	}

	public void setClaveSistema(String claveSistema) {
		this.claveSistema = claveSistema;
	}

	public String getCreadoPor() {
		return this.creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getModificadoPor() {
		return this.modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<CofBitacora> getCofBitacoras() {
		return this.cofBitacoras;
	}

	public void setCofBitacoras(List<CofBitacora> cofBitacoras) {
		this.cofBitacoras = cofBitacoras;
	}

	public CofBitacora addCofBitacora(CofBitacora cofBitacora) {
		getCofBitacoras().add(cofBitacora);
		cofBitacora.setCofOperacione(this);

		return cofBitacora;
	}

	public CofBitacora removeCofBitacora(CofBitacora cofBitacora) {
		getCofBitacoras().remove(cofBitacora);
		cofBitacora.setCofOperacione(null);

		return cofBitacora;
	}

}