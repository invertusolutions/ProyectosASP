package com.asp.corresponsal.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.asp.corresponsal.utils.ActivityLogEJB;
import com.asp.corresponsal.bean.Response;
import com.asp.corresponsal.utils.ConstantesUtil;
import com.asp.corresponsal.ws.BolsonResponseWS;
import com.asp.corresponsal.ws.ClienteREST;
import com.asp.corresponsal.ws.ResponseWS;

@ManagedBean(name = "ampliacionData", eager = true)
@SessionScoped
public class AmpliacionData implements Serializable {

   private static final long serialVersionUID = 1L;
   private String inputCuenta;
   private String inputMonto;
   private String cuenta;
   private String monto;
   private Response response;
   
   public void buscar(AjaxBehaviorEvent event){
	    
	   ClienteREST cliente = new ClienteREST();
	   BolsonResponseWS restResponse = new BolsonResponseWS();
	   response = new Response();

	   if(StringUtils.isNotEmpty(inputCuenta)){
		   restResponse = cliente.montoBolson(inputCuenta);
		   cuenta = restResponse.getCuenta();
		   monto = restResponse.getMonto();
	   } else {
		   cuenta = "";
		   monto = "";
	   }

	   if(StringUtils.isNotEmpty(inputCuenta) && StringUtils.isNotEmpty(restResponse.getMensaje())
			   && !ConstantesUtil.OK.equals(restResponse.getMensaje())){
		   response.setName(ConstantesUtil.FAIL_MSG);
		   response.setDescripcion(restResponse.getMensaje());
		   response.setIcon(ConstantesUtil.ICON_ALERT);
		   response.setDivStyle(ConstantesUtil.DIV_ALERT);
	   }
   }
   
   public void actualizar(AjaxBehaviorEvent event){
	   inputCuenta = "";
	   
	   ClienteREST cliente = new ClienteREST();
	   ResponseWS restResponse = new ResponseWS();
	   response = new Response();
	   String validMsg = validate();
	   boolean isValid = ConstantesUtil.OK.equals(validMsg);
	   
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	   
	   if(isValid){
		   restResponse = cliente.ampliarBolson(cuenta, inputMonto);
	   }
	   
	   if (!isValid && !"empty".equals(validMsg)){
		   response.setName(ConstantesUtil.FAIL_MSG);
		   response.setDescripcion(validMsg);
		   response.setIcon(ConstantesUtil.ICON_ALERT);
		   response.setDivStyle(ConstantesUtil.DIV_ALERT);
		  
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEAPLB, user, user, 0, ConstantesUtil.FAIL_MSG);

		   
	   } else if(ConstantesUtil.OK.equals(restResponse.getMensaje())){
		   response.setName(ConstantesUtil.SUCCESS_MSG);
		   response.setDescripcion("Su contraseña se ha actualizado");
		   response.setIcon(ConstantesUtil.ICON_INFO);
		   response.setDivStyle(ConstantesUtil.DIV_INFO);
		   monto = inputMonto;
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEAPLB, user, user, 1, ConstantesUtil.SUCCESS_MSG);
		   
	   } else if(StringUtils.isNotEmpty(restResponse.getMensaje())){
		   response.setName(ConstantesUtil.FAIL_MSG);
		   response.setDescripcion(restResponse.getMensaje());
		   response.setIcon(ConstantesUtil.ICON_ALERT);
		   response.setDivStyle(ConstantesUtil.DIV_ALERT);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEAPLB, user, user, 0, ConstantesUtil.FAIL_MSG);
	   }
   }
   private String validate(){
	   char[] charArray = {'0','1','2','3','4','5','6','7','8','9','.'};
	   if(StringUtils.isEmpty(inputMonto) || StringUtils.isEmpty(cuenta)){
		   return "empty";
	   } else if(!StringUtils.containsOnly(inputMonto,charArray) ){
		   return "Su monto es incorrecto";
	   } 
	   
	   return ConstantesUtil.OK;
   }
/**
 * @return the inputCuenta
 */
public String getInputCuenta() {
	return inputCuenta;
}
/**
 * @param inputCuenta the inputCuenta to set
 */
public void setInputCuenta(String inputCuenta) {
	this.inputCuenta = inputCuenta;
}
/**
 * @return the inputMonto
 */
public String getInputMonto() {
	return inputMonto;
}
/**
 * @param inputMonto the inputMonto to set
 */
public void setInputMonto(String inputMonto) {
	this.inputMonto = inputMonto;
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
 * @return the response
 */
public Response getResponse() {
	return response;
}
/**
 * @param response the response to set
 */
public void setResponse(Response response) {
	this.response = response;
}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}