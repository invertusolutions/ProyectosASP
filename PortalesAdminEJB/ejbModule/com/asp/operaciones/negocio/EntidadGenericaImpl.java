package com.asp.operaciones.negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class EntidadGenericaImpl<T> implements EntidadGenerica<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@PersistenceContext(name="ASPServiciosAdministracion")
	protected EntityManager em;
	
	private Class<T> tipo;

	public EntidadGenericaImpl() {
	}
	
	public T guardar(final T t) {
		this.em.persist(t);
		return t;
	}

	public void borrar(final T t) {
		this.em.remove(t);
	}

	@SuppressWarnings("unchecked")
	public T buscarPorId(String llave, Object id) {
		
		Query q = em.createQuery(
				"SELECT e FROM " + tipo.getClass().getName() + " e WHERE e." + llave + "= :id");
		
		q.setParameter("id", id);
		
		return (T)q.getSingleResult();
	}

	public T actualizar(final T t) {
		return this.em.merge(t);
	}
	
	@SuppressWarnings("rawtypes")
	public List obtenerLista(){
		Query q = em.createQuery(
				"SELECT e FROM " + tipo.getClass().getName() + " e");
		
		return q.getResultList();
		
	}

}
