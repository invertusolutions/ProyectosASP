package com.asp.comisionista.bean;

public class Response {
	private String name;
	private String descripcion;
	private String divStyle;
	private String tableStyle;
	private String icon;

	public Response() {
		this.name = "";
		this.descripcion = "";
		this.icon = "";
		this.divStyle = "";
		tableStyle = "";
		
	}
	public Response(String descripcion) {
		this.descripcion = descripcion;
	}
	public Response(String name, String descripcion, String icon, String div) {
		this.name = name;
		this.descripcion = descripcion;
		this.icon = icon;
		this.divStyle = div;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDivStyle() {
		return divStyle;
	}
	public void setDivStyle(String divStyle) {
		this.divStyle = divStyle;
	}
	public String getTableStyle() {
		return tableStyle;
	}
	public void setTableStyle(String tableStyle) {
		this.tableStyle = tableStyle;
	}

}
