package com.asp.comisionista.ws;

public class NumAutResponseWS extends ResponseWS{
	private String numAut;
	
	public NumAutResponseWS() {
		
	}

	public NumAutResponseWS(String mensaje) {
		this.setMensaje(mensaje);
	}	
	/**
	 * @return the numAut
	 */
	public String getNumAut() {
		return numAut;
	}

	/**
	 * @param numAut the numAut to set
	 */
	public void setNumAut(String numAut) {
		this.numAut = numAut;
	}

}
