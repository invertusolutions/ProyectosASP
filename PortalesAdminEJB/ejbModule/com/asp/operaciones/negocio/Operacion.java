package com.asp.operaciones.negocio;

import java.util.List;

import javax.persistence.Query;

import com.asp.operaciones.modelo.CofOperacione;

public class Operacion extends EntidadGenericaImpl<CofOperacione> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void guardarOperacion(String clave_op, String clave_sis, String nombre, 
			String creado_por, String modificador_por, String descripcion){
		
		CofOperacione op = new CofOperacione();
		
		op.setClaveOperacion(clave_op);
		op.setClaveSistema(clave_sis);
		op.setNombre(nombre);
		op.setDescripcion(descripcion);
		op.setCreadoPor(creado_por);
		op.setModificadoPor(modificador_por);
		
		guardar(op);
	}
	
	
	@SuppressWarnings("rawtypes")
	public List obtenerOperacionesActivas(){	
		Query q = em.createQuery("SELECT c FROM CofOperacione c where c.status = 1");
		return q.getResultList();
	}
	
	

}
