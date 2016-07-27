package com.asp.operaciones.negocio;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.asp.operaciones.modelo.CofBitacora;
import com.asp.operaciones.modelo.CofOperacione;

public class Bitacora extends EntidadGenericaImpl<CofBitacora> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void guardarEvento(String clave_op, String usuario_inf, String usuario_op, int estatus, String error){
		
		Operacion op = new Operacion();
		CofOperacione cOp = (CofOperacione)op.buscarPorId("claveOperacion", clave_op);
		CofBitacora cBi = new CofBitacora();
		
		cBi.setCofOperacione(cOp);
		cBi.setError(error);
		cBi.setStatusOperacion(estatus);
		cBi.setUsuarioInformado(usuario_inf);
		cBi.setUsuarioOperacion(usuario_op);
		
		this.guardar(cBi);
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public List buscarBitacora(String tipo_op, String usuario, Date fecha_inicio, Date fecha_fin){
		
		StringBuilder sq = new StringBuilder("select c from CofBitacora c ");
		
		if(nuloOVacio(tipo_op) || nuloOVacio(usuario) 
				|| nuloOVacio(fecha_inicio) || nuloOVacio(fecha_fin)){
			
			sq.append("WHERE ");
			
			boolean unaCond = false;
			if(nuloOVacio(usuario)){
				
				sq.append(unaCond ? "AND " : "");
				unaCond = true;
				sq.append("c.usuarioOperacion = :usuario "); 
				
			}
			if(nuloOVacio(tipo_op)){
				
				sq.append(unaCond ? "AND " : "");
				unaCond = true;
				sq.append("c.cofOperacione.claveOperacion = :opera ");
			}
			
			if(nuloOVacio(fecha_inicio) && nuloOVacio(fecha_fin)){
				
				sq.append(unaCond ? "AND " : "");
				unaCond = true;
				sq.append("c.id.fecha BETWEEN  :fecini AND :fecfin ");
				
			} else {
				
				sq.append(unaCond ? "AND " : "");
				unaCond = true;
				
				if(nuloOVacio(fecha_inicio)){
					sq.append("c.id.fecha > :fecini ");
				}
				
				if(nuloOVacio(fecha_fin)){
					sq.append("c.id.fecha < :fecfin ");
				}				
			}
			
		}
		
		Query q = em.createQuery(sq.toString());
		
		if(sq.indexOf(":opera") > 0){
			q.setParameter(":opera", tipo_op);
		}
		
		if(sq.indexOf(":usuario") > 0){
			q.setParameter(":usuario", usuario);
		}
		
		if(sq.indexOf(":fecini") > 0){
			q.setParameter(":fecini", fecha_inicio);
		}
		
		if(sq.indexOf(":fecfin") > 0){
			q.setParameter(":fecfin", fecha_fin);
		}

		return q.getResultList();
	}
	
	private boolean nuloOVacio(String s){
		return s != null && s.length() > 0;
	}
	
	private boolean nuloOVacio(Date s){
		return s != null;
	}
	
}
