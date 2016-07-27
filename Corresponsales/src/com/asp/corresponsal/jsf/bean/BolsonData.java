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
import com.asp.corresponsal.ws.DetalleBolsonResponseWS;
import com.asp.corresponsal.ws.ResponseWS;

@ManagedBean(name = "bolsonData", eager = true)
@SessionScoped
public class BolsonData implements Serializable {

   private static final long serialVersionUID = 1L;
   private String blqUser;
   private String desUser;
   private Response blqResponse;
   private Response desResponse;
   private DetalleBolsonResponseWS[] bolsonBlqList;
   private DetalleBolsonResponseWS[] bolsonDesList;


   public void bloquear(AjaxBehaviorEvent event){
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	   
	   ClienteREST cliente = new ClienteREST();
	   ResponseWS restResponse = new ResponseWS();
	   blqResponse = new Response();
	   blqResponse.setTableStyle(ConstantesUtil.DIV_INFO);
	   
	   if(StringUtils.isNotEmpty(user) && bolsonBlqList.length > 0){
		   restResponse = cliente.bloqueaBolson(user, bolsonBlqList[0].getId());
	   }
	   
	   if(ConstantesUtil.OK.equals(restResponse.getMensaje())){
		   blqResponse.setName(ConstantesUtil.SUCCESS_MSG);
		   blqResponse.setDescripcion("Se ha bloqueado el Bolsón");
		   blqResponse.setIcon(ConstantesUtil.ICON_INFO);
		   blqResponse.setDivStyle(ConstantesUtil.DIV_INFO);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEBLBL, user, user, 1, ConstantesUtil.SUCCESS_MSG);

		   
	   } else if (StringUtils.isNotEmpty(restResponse.getMensaje())){
		   blqResponse.setName(ConstantesUtil.FAIL_MSG);
		   blqResponse.setDescripcion(restResponse.getMensaje());
		   blqResponse.setIcon(ConstantesUtil.ICON_ALERT);
		   blqResponse.setDivStyle(ConstantesUtil.DIV_ALERT);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEBLBL, user, user, 0, ConstantesUtil.FAIL_MSG);

	   }
   }
   public void desbloquear(AjaxBehaviorEvent event){
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	   
	   ClienteREST cliente = new ClienteREST();
	   ResponseWS restResponse = new ResponseWS();
	   desResponse = new Response();
	   desResponse.setTableStyle(ConstantesUtil.DIV_INFO);
	   
	   if(StringUtils.isNotEmpty(user) && bolsonDesList.length > 0){
		   restResponse = cliente.desbloqueaBolson(user, bolsonDesList[0].getId());
	   }
	   
	   if(ConstantesUtil.OK.equals(restResponse.getMensaje())){
		   desResponse.setName(ConstantesUtil.SUCCESS_MSG);
		   desResponse.setDescripcion("Se ha desbloqueado el Bolsón");
		   desResponse.setIcon(ConstantesUtil.ICON_INFO);
		   desResponse.setDivStyle(ConstantesUtil.DIV_INFO);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEDLBL, user, user, 1, ConstantesUtil.SUCCESS_MSG);

		   
	   } else if (StringUtils.isNotEmpty(restResponse.getMensaje())){
		   desResponse.setName(ConstantesUtil.FAIL_MSG);
		   desResponse.setDescripcion(restResponse.getMensaje());
		   desResponse.setIcon(ConstantesUtil.ICON_ALERT);
		   desResponse.setDivStyle(ConstantesUtil.DIV_ALERT);
		   
		   ActivityLogEJB.obtenerLog().guardarEvento(ConstantesUtil.CVEDLBL, user, user, 0, ConstantesUtil.FAIL_MSG);

	   }
   }
   public void buscarDesbloqueados(AjaxBehaviorEvent event){
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	   
	   DetalleBolsonResponseWS detalleBolson = new DetalleBolsonResponseWS();
	   desResponse = new Response();
	   bolsonDesList = null;
	   
	   if(StringUtils.isNotEmpty(user) && StringUtils.isNotEmpty(desUser)){
		   detalleBolson = findBolson(user, desUser);
	   }
	   
	   if(ConstantesUtil.OK.equals(detalleBolson.getMensaje()) && StringUtils.isNotEmpty(detalleBolson.getId())){
		   desResponse.setTableStyle(ConstantesUtil.DIV_INFO);
		   bolsonDesList = new DetalleBolsonResponseWS[1];
		   bolsonDesList[0] = detalleBolson;
		   
	   } else if (StringUtils.isNotEmpty(detalleBolson.getMensaje())){
		   desResponse.setName(ConstantesUtil.FAIL_MSG);
		   desResponse.setDescripcion(detalleBolson.getMensaje());
		   desResponse.setIcon(ConstantesUtil.ICON_ALERT);
		   desResponse.setDivStyle(ConstantesUtil.DIV_ALERT);
	   }
   }
   public void buscarBloqueados(AjaxBehaviorEvent event){
	   FacesContext context = FacesContext.getCurrentInstance();
	   HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	   String user = session.getAttribute("username").toString();
	   
	   DetalleBolsonResponseWS detalleBolson = new DetalleBolsonResponseWS();
	   blqResponse = new Response();
	   bolsonBlqList = null;
	   
	   if(StringUtils.isNotEmpty(user) && StringUtils.isNotEmpty(blqUser)){
		   detalleBolson = findBolson(user, blqUser);
	   }
	   
	   if(ConstantesUtil.OK.equals(detalleBolson.getMensaje()) && StringUtils.isNotEmpty(detalleBolson.getId())){
		   blqResponse.setTableStyle(ConstantesUtil.DIV_INFO);
		   bolsonBlqList = new DetalleBolsonResponseWS[1];
		   bolsonBlqList[0] = detalleBolson;
		   
	   } else if (StringUtils.isNotEmpty(detalleBolson.getMensaje())){
		   blqResponse.setName(ConstantesUtil.FAIL_MSG);
		   blqResponse.setDescripcion(detalleBolson.getMensaje());
		   blqResponse.setIcon(ConstantesUtil.ICON_ALERT);
		   blqResponse.setDivStyle(ConstantesUtil.DIV_ALERT);
	   }
   }
   
   private DetalleBolsonResponseWS findBolson(String user, String valor){
	   String[] criterio = {"rfc","razonSocial","id"};
	   ClienteREST cliente = new ClienteREST();
	   DetalleBolsonResponseWS restResponse = new DetalleBolsonResponseWS();
	   boolean isNotFinish = true;
	   int index = 0;
	   while (index < criterio.length && isNotFinish) {
		   restResponse = cliente.findBolson(user, valor, criterio[index++]);
		   if(ConstantesUtil.OK.equals(restResponse.getMensaje()) && StringUtils.isNotEmpty(restResponse.getId())){
			   isNotFinish = false;
		   }
	   }

	   return restResponse;
   }
/**
 * @return the blqUser
 */
public String getBlqUser() {
	return blqUser;
}
/**
 * @param blqUser the blqUser to set
 */
public void setBlqUser(String blqUser) {
	this.blqUser = blqUser;
}
/**
 * @return the desUser
 */
public String getDesUser() {
	return desUser;
}
/**
 * @param desUser the desUser to set
 */
public void setDesUser(String desUser) {
	this.desUser = desUser;
}
/**
 * @return the blqResponse
 */
public Response getBlqResponse() {
	return blqResponse;
}
/**
 * @param blqResponse the blqResponse to set
 */
public void setBlqResponse(Response blqResponse) {
	this.blqResponse = blqResponse;
}
/**
 * @return the desResponse
 */
public Response getDesResponse() {
	return desResponse;
}
/**
 * @param desResponse the desResponse to set
 */
public void setDesResponse(Response desResponse) {
	this.desResponse = desResponse;
}
/**
 * @return the bolsonBlqList
 */
public DetalleBolsonResponseWS[] getBolsonBlqList() {
	return bolsonBlqList;
}
/**
 * @param bolsonBlqList the bolsonBlqList to set
 */
public void setBolsonBlqList(DetalleBolsonResponseWS[] bolsonBlqList) {
	this.bolsonBlqList = bolsonBlqList;
}
/**
 * @return the bolsonDesList
 */
public DetalleBolsonResponseWS[] getBolsonDesList() {
	return bolsonDesList;
}
/**
 * @param bolsonDesList the bolsonDesList to set
 */
public void setBolsonDesList(DetalleBolsonResponseWS[] bolsonDesList) {
	this.bolsonDesList = bolsonDesList;
}
/**
 * @return the serialversionuid
 */
public static long getSerialversionuid() {
	return serialVersionUID;
}

}