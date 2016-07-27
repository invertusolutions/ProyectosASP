package com.asp.comisionista.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.asp.comisionista.bean.Response;
import com.asp.comisionista.utils.ActivityLogEJB;
import com.asp.comisionista.utils.ConstantesUtil;
import com.asp.comisionista.ws.ClienteREST;
import com.asp.comisionista.ws.NumAutResponseWS;
import com.asp.comisionista.ws.ResponseWS;

@ManagedBean(name = "securityData", eager = true)
@SessionScoped
public class SecurityData implements Serializable {

   private static final long serialVersionUID = 1L;
   private String pwd;
   private String newPwd;
   private String newPwdConfirm;
   private String pwdToken;
   private Response pwdResponse;
   private Response tokenResponse;

   
   public void actualizarPWD (AjaxBehaviorEvent event){
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	   
	   ClienteREST cliente = new ClienteREST();
	   ResponseWS restResponse = new ResponseWS();
	   pwdResponse = new Response();
	   String validMsg = validate();
	   boolean isValid = ConstantesUtil.OK.equals(validMsg);
	   
	   if(StringUtils.isNotEmpty(user) && isValid){
		   restResponse = cliente.changePwd(user, pwd, newPwd);
	   }
	   
	   if (!isValid){
		   pwdResponse.setName(ConstantesUtil.FAIL_MSG);
		   pwdResponse.setDescripcion(validMsg);
		   pwdResponse.setIcon(ConstantesUtil.ICON_ALERT);
		   pwdResponse.setDivStyle(ConstantesUtil.DIV_ALERT);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.cveCHPW, user, user, 0, ConstantesUtil.FAIL_MSG);
		   
	   } else if(ConstantesUtil.OK.equals(restResponse.getMensaje())){
		   pwdResponse.setName(ConstantesUtil.SUCCESS_MSG);
		   pwdResponse.setDescripcion("Su contraseña se ha actualizado");
		   pwdResponse.setIcon(ConstantesUtil.ICON_INFO);
		   pwdResponse.setDivStyle(ConstantesUtil.DIV_INFO);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.cveCHPW, user, user, 1, ConstantesUtil.SUCCESS_MSG);
		   
	   } else {
		   pwdResponse.setName(ConstantesUtil.FAIL_MSG);
		   pwdResponse.setDescripcion(restResponse.getMensaje());
		   pwdResponse.setIcon(ConstantesUtil.ICON_ALERT);
		   pwdResponse.setDivStyle(ConstantesUtil.DIV_ALERT);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.cveCHPW, user, user, 0, ConstantesUtil.FAIL_MSG);
	   }
	   
   }
   
   private String validate(){
	   if(StringUtils.isEmpty(pwd) || StringUtils.isEmpty(newPwd) || StringUtils.isEmpty(newPwdConfirm)){
		   return "Sus datos son incorrectos";
	   } else if(!StringUtils.equals(newPwd,newPwdConfirm)){
		   return "Su contraseña nueva y la confirmación deben ser iguales";
	   }
	   return ConstantesUtil.OK;
   }
   
   public void consultarToken (AjaxBehaviorEvent event){
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	   
	   ClienteREST cliente = new ClienteREST();
	   NumAutResponseWS restResponse = new NumAutResponseWS();
	   
	   if(StringUtils.isNotEmpty(user) && StringUtils.isNotEmpty(pwdToken)){
		   restResponse = cliente.autToken(user, pwdToken);
	   }
	   tokenResponse = new Response();
	   
	   if(ConstantesUtil.OK.equals(restResponse.getMensaje())){
		   tokenResponse.setName(ConstantesUtil.SUCCESS_MSG);
		   tokenResponse.setDescripcion("El número de autorización generado es: " + restResponse.getNumAut());
		   tokenResponse.setIcon(ConstantesUtil.ICON_INFO);
		   tokenResponse.setDivStyle(ConstantesUtil.DIV_INFO);    
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.cveSOLT , user, user, 1, ConstantesUtil.SUCCESS_MSG);

		   
	   } else if(StringUtils.isNotEmpty(restResponse.getMensaje())){
		   tokenResponse.setName(ConstantesUtil.FAIL_MSG);
		   tokenResponse.setDescripcion(restResponse.getMensaje());
		   tokenResponse.setIcon(ConstantesUtil.ICON_ALERT);
		   tokenResponse.setDivStyle(ConstantesUtil.DIV_ALERT);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.cveSOLT , user, user, 0, ConstantesUtil.FAIL_MSG);

	   }

   }

/**
 * @return the pwd
 */
public String getPwd() {
	return pwd;
}

/**
 * @param pwd the pwd to set
 */
public void setPwd(String pwd) {
	this.pwd = pwd;
}

/**
 * @return the newPwd
 */
public String getNewPwd() {
	return newPwd;
}

/**
 * @param newPwd the newPwd to set
 */
public void setNewPwd(String newPwd) {
	this.newPwd = newPwd;
}

/**
 * @return the newPwdConfirm
 */
public String getNewPwdConfirm() {
	return newPwdConfirm;
}

/**
 * @param newPwdConfirm the newPwdConfirm to set
 */
public void setNewPwdConfirm(String newPwdConfirm) {
	this.newPwdConfirm = newPwdConfirm;
}

/**
 * @return the pwdResponse
 */
public Response getPwdResponse() {
	return pwdResponse;
}

/**
 * @param pwdResponse the pwdResponse to set
 */
public void setPwdResponse(Response pwdResponse) {
	this.pwdResponse = pwdResponse;
}

/**
 * @return the tokenResponse
 */
public Response getTokenResponse() {
	return tokenResponse;
}

/**
 * @param tokenResponse the tokenResponse to set
 */
public void setTokenResponse(Response tokenResponse) {
	this.tokenResponse = tokenResponse;
}

/**
 * @return the serialversionuid
 */
public static long getSerialversionuid() {
	return serialVersionUID;
}

/**
 * @return the pwdToken
 */
public String getPwdToken() {
	return pwdToken;
}

/**
 * @param pwdToken the pwdToken to set
 */
public void setPwdToken(String pwdToken) {
	this.pwdToken = pwdToken;
}
}