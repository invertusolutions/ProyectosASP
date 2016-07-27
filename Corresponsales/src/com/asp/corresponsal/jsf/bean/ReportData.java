package com.asp.corresponsal.jsf.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.asp.corresponsal.bean.Response;
import com.asp.corresponsal.utils.ActivityLogEJB;
import com.asp.corresponsal.utils.ConstantesUtil;
import com.asp.operaciones.modelo.CofOperacione;

@ManagedBean(name = "reportData", eager = true)
@SessionScoped
public class ReportData implements Serializable {

   private static final long serialVersionUID = 1L;
   private String tipoOperacion;
   private String user;
   private String fechaIni;
   private String fechaFin;
   private Response response;
   private List<CofOperacione> reportList;
   
   @SuppressWarnings("unchecked")
public void buscar(AjaxBehaviorEvent event){
	   response = new Response();
	   response.setTableStyle(ConstantesUtil.DIV_INFO);
	   /*reportList = new Report[1];
	   System.out.println(fechaIni);
	   Report report = new Report();
	   report.setDescripcion("descripcion");
	   report.setEstatus("estatus");
	   report.setFechaHora("fechaHora");
	   report.setFolio("folio");
	   report.setOperacion("operacion");
	   report.setUsuario("usuario");
	   reportList[0] = report;*/
	   
	   reportList = ActivityLogEJB.obtenerLog().buscarBitacora("", "", null, null);
	   
   }
   public void imprimir(AjaxBehaviorEvent event){
	   response = new Response();
	   reportList = null;
   }

	/**
	 * @return the tipoOperacion
	 */
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	/**
	 * @param tipoOperacion the tipoOperacion to set
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
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
	 * @return the fechaIni
	 */
	public String getFechaIni() {
		return fechaIni;
	}
	/**
	 * @param fechaIni the fechaIni to set
	 */
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
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
	/**
	 * @return the report
	 */
	@SuppressWarnings("rawtypes")
	public List getReportList() {
		return reportList;
	}
	/**
	 * @param report the report to set
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setReportList(List reportList) {
		this.reportList = reportList;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}