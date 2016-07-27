package com.asp.operaciones.ejb.remote;


import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BitacoraBeanRemote {
	
	@SuppressWarnings("rawtypes")
	public List buscarBitacora(String tipo_op, String usuario, Date fecha_inicio, Date fecha_fin);
	public void guardarEvento(String clave_op, String usuario_inf, String usuario_op, int estatus, String error);
	public void guardarOperacion(String clave_op, String clave_sis, String nombre, 
			String creado_por, String modificador_por, String descripcion);
	@SuppressWarnings("rawtypes")
	public List obtenerOperaciones();
}
