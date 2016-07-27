package com.asp.comisionista.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConstantesUtil {

	private static final String BUNDLE_CONEXION_REMOTA = "ConexionRemota";
	private static final String BUNDLE_CONFIGURACION = "Conf";
	
	public static final String ICON_INFO = "ui-icon ui-icon-info";
	public static final String ICON_ALERT = "ui-icon ui-icon-alert";
	public static final String DIV_INFO = "ui-state-highlight ui-corner-all";
	public static final String DIV_ALERT = "ui-state-error ui-corner-all";
	
	public static final ResourceBundle RESOURCE_CONFIGURACION = ResourceBundle.getBundle(BUNDLE_CONFIGURACION, new Locale("es","Mx"));
	
	public static final String RUTA_ARCHIVO = RESOURCE_CONFIGURACION.getString("RUTA_ARCHIVO");
    public static final ResourceBundle RESOURCE_CONEXION_REMOTA = ResourceBundle.getBundle(BUNDLE_CONEXION_REMOTA, new Locale("es","Mx"));

    public static final String WS_LOGIN = RESOURCE_CONFIGURACION.getString("WS_LOGIN");
    public static final String WS_CAMBIO_PASS = RESOURCE_CONFIGURACION.getString("WS_CAMBIO_PASS");
    public static final String WS_SALDO_CORRESPONSAL = RESOURCE_CONFIGURACION.getString("WS_SALDO_CORRESPONSAL");
    public static final String WS_AUT_TOKEN = RESOURCE_CONFIGURACION.getString("WS_AUT_TOKEN");
    public static final String WS_LEER_TOKEN = RESOURCE_CONFIGURACION.getString("WS_LEER_TOKEN");
    
    public static final String SUCCESS_MSG = "Operación exitosa";
    public static final String FAIL_MSG = "Operación no exitosa";
    public static final String OK = "OK";

    public static final String ACTIVITY_LOG_BEAN = RESOURCE_CONFIGURACION.getString("ACTIVITY_LOG_BEAN");
    
    
    public static final String cveCHPW = "CHPW";
    public static final String cveSOLT = "SOLT";
    public static final String cveENVA = "ENVA";
    
}
