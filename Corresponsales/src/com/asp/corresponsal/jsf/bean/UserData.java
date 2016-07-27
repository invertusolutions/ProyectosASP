package com.asp.corresponsal.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.asp.corresponsal.bean.Response;
import com.asp.corresponsal.utils.ActivityLogEJB;
import com.asp.corresponsal.utils.ConstantesUtil;
import com.asp.corresponsal.ws.ClienteREST;
import com.asp.corresponsal.ws.ResponseWS;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {

   private static final long serialVersionUID = 1L;
   private String desUser;
   private String blqUser;
   private Response desResponse;
   private Response blqResponse;

   public void bloquear(AjaxBehaviorEvent event){
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	   
	   ClienteREST cliente = new ClienteREST();
	   ResponseWS restResponse = new ResponseWS();
	   blqResponse = new Response();
	   
	   if(StringUtils.isNotEmpty(user) && StringUtils.isNotEmpty(blqUser)){
		   restResponse = cliente.bloqueaUsr(user, blqUser);
	   }
	   
	   if(ConstantesUtil.OK.equals(restResponse.getMensaje())){
		   blqResponse.setName(ConstantesUtil.SUCCESS_MSG);
		   blqResponse.setDescripcion("Se ha bloqueado el usuario: " + blqUser);
		   blqResponse.setIcon(ConstantesUtil.ICON_INFO);
		   blqResponse.setDivStyle(ConstantesUtil.DIV_INFO);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEBLUS, user, user, 1, ConstantesUtil.SUCCESS_MSG);

		   
	   } else if (StringUtils.isNotEmpty(restResponse.getMensaje())){
		   blqResponse.setName(ConstantesUtil.FAIL_MSG);
		   blqResponse.setDescripcion(restResponse.getMensaje());
		   blqResponse.setIcon(ConstantesUtil.ICON_ALERT);
		   blqResponse.setDivStyle(ConstantesUtil.DIV_ALERT);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEBLUS, user, user, 0, ConstantesUtil.FAIL_MSG);

	   }
   }
   public void desbloquear(AjaxBehaviorEvent event){
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	   
	   ClienteREST cliente = new ClienteREST();
	   ResponseWS restResponse = new ResponseWS();
	   desResponse = new Response();
	   
	   if(StringUtils.isNotEmpty(user) && StringUtils.isNotEmpty(desUser)){
		   restResponse = cliente.desbloqueaBolson(user, desUser);
	   }
	   
	   if(ConstantesUtil.OK.equals(restResponse.getMensaje())){
		   desResponse.setName(ConstantesUtil.SUCCESS_MSG);
		   desResponse.setDescripcion("Se ha desbloqueado el usuario: " + desUser);
		   desResponse.setIcon(ConstantesUtil.ICON_INFO);
		   desResponse.setDivStyle(ConstantesUtil.DIV_INFO);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEDLUS, user, user, 1, ConstantesUtil.SUCCESS_MSG);

		   
	   } else if (StringUtils.isNotEmpty(restResponse.getMensaje())){
		   desResponse.setName(ConstantesUtil.FAIL_MSG);
		   desResponse.setDescripcion(restResponse.getMensaje());
		   desResponse.setIcon(ConstantesUtil.ICON_ALERT);
		   desResponse.setDivStyle(ConstantesUtil.DIV_ALERT);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEDLUS, user, user, 0, ConstantesUtil.FAIL_MSG);

	   }
   }

public String getDesUser() {
	return desUser;
}

public void setDesUser(String desUser) {
	this.desUser = desUser;
}

public String getBlqUser() {
	return blqUser;
}

public void setBlqUser(String blqUser) {
	this.blqUser = blqUser;
}

public Response getDesResponse() {
	return desResponse;
}

public void setDesResponse(Response desResponse) {
	this.desResponse = desResponse;
}

public Response getBlqResponse() {
	return blqResponse;
}

public void setBlqResponse(Response blqResponse) {
	this.blqResponse = blqResponse;
}

}