package com.asp.comisionista.ws;

public class BolsonResponseWS extends ResponseWS{
	private String cuenta;
	private String monto;
	private String saldo;
	
	public BolsonResponseWS() {
		cuenta = "";
		monto = "";
		saldo = "";
	}

	public BolsonResponseWS(String mensaje) {
		this.setMensaje(mensaje);
		cuenta = "";
		monto = "";
		saldo = "";
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

	/**
	 * @return the saldo
	 */
	public String getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

}
