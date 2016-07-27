package com.asp.operaciones.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.asp.operaciones.ejb.local.BitacoraBeanLocal;
import com.asp.operaciones.ejb.remote.BitacoraBeanRemote;
import com.asp.operaciones.negocio.Bitacora;
import com.asp.operaciones.negocio.Operacion;


/**
 * Session Bean implementation class BitacoraEJB
 */
@Stateless
@Remote(BitacoraBeanRemote.class)
public class BitacoraBean implements BitacoraBeanRemote, BitacoraBeanLocal {

	
	private Bitacora bi;
	private Operacion op;

    public BitacoraBean() { bi = new Bitacora(); op = new Operacion();   }
    

		
	public void guardarEvento(String clave_op, String usuario_inf, String usuario_op, int estatus, String error){
		
		bi.guardarEvento(clave_op, usuario_inf, usuario_op, estatus, error);
		
	}
	
	public void guardarOperacion(String clave_op, String clave_sis, String nombre, 
			String creado_por, String modificador_por, String descripcion){
		
		op.guardarOperacion(clave_op, clave_sis, nombre, creado_por, modificador_por, descripcion);
		
		}
	
	@SuppressWarnings("rawtypes")
	public List buscarBitacora(String tipo_op, String usuario, Date fecha_inicio, Date fecha_fin){
		
		return bi.buscarBitacora(tipo_op, usuario, fecha_inicio, fecha_fin);
		
	}

	@SuppressWarnings("rawtypes")
	public List obtenerOperaciones() {
		
		return op.obtenerOperacionesActivas();
	}


}
