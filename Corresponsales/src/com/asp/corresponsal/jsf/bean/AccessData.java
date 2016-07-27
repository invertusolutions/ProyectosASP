package com.asp.corresponsal.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.lang.StringUtils;

import com.asp.corresponsal.bean.Response;
import com.asp.corresponsal.utils.ConstantesUtil;
import com.asp.corresponsal.ws.ClienteREST;
import com.asp.corresponsal.ws.ResponseWS;

@ManagedBean(name = "accessData", eager = true)
@SessionScoped
public class AccessData implements Serializable {

   private static final long serialVersionUID = 1L;
   private String user;
   private String pwd;
   private Response response;

   
   public String login(){
	   String result = ""; 
	   ClienteREST cliente = new ClienteREST();
	   
	   ResponseWS restResponse = new ResponseWS();
	   
	   if(validate()){
		   restResponse = cliente.login(user, pwd);
		   response = new Response(restResponse.getMensaje());   
	   } else {
		   response = new Response("Sus datos no son correctos");
	   }
	   
	   if(ConstantesUtil.OK.equals(restResponse.getMensaje())){
		   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user);
		   result = "exito";
	   }
	   
	   return result;
   }
   private boolean validate(){
	   if(StringUtils.isEmpty(user) || StringUtils.isEmpty(pwd)){
		   return false;
	   }
	   return true;
   }
   
   public void logout(AjaxBehaviorEvent event){
	   FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
   }



/**
 * @return the user
 */
public String getUser() {
	return user;
}

/**
 * @param user the user to set
 */
public void setUser(String user) {
	this.user = user;
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
   
 
}