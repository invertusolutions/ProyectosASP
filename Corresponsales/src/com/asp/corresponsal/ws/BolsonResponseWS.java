package com.asp.corresponsal.ws;

public class BolsonResponseWS extends ResponseWS{
	private String cuenta;
	private String monto;
	
	public BolsonResponseWS() {

	}

	public BolsonResponseWS(String mensaje) {
		this.setMensaje(mensaje);
	}

	/**
	 * @return the cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * @return the monto
	 */
	public String getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(String monto) {
		this.monto = monto;
	}

}
