package com.asp.comisionista.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.asp.comisionista.ws.BolsonResponseWS;
import com.asp.comisionista.ws.ClienteREST;

@ManagedBean(name = "bolsonData", eager = true)
@SessionScoped
public class BolsonData implements Serializable {

   private static final long serialVersionUID = 1L;
   private String numeroCuenta;
   private String monto;
   private String saldo;

   
   public BolsonData (){
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	    
	   ClienteREST cliente = new ClienteREST();
	   BolsonResponseWS restResponse = new BolsonResponseWS();
	   
	   if(StringUtils.isNotEmpty(user)){
		   restResponse = cliente.findBolson(user);
	   }
	   
	   numeroCuenta = restResponse.getCuenta();
	   monto = restResponse.getMonto();
	   saldo = restResponse.getSaldo();
   }


/**
 * @return the numeroCuenta
 */
public String getNumeroCuenta() {
	return numeroCuenta;
}


/**
 * @param numeroCuenta the numeroCuenta to set
 */
public void setNumeroCuenta(String numeroCuenta) {
	this.numeroCuenta = numeroCuenta;
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