package com.asp.operaciones.negocio;

public interface EntidadGenerica<T> {
	T guardar(T t);
	void borrar(T t);
	T buscarPorId(String llave, Object id);
	T actualizar(T t);
}
