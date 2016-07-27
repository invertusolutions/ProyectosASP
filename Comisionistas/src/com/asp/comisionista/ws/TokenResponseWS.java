package com.asp.comisionista.ws;

public class TokenResponseWS extends ResponseWS{
	private String token;
	
	public TokenResponseWS() {
		
	}	
	public TokenResponseWS(String mensaje) {
		this.setMensaje(mensaje);
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}


}
