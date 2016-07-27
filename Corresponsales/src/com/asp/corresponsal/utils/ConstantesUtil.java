package com.asp.corresponsal.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConstantesUtil {

	private static final String BUNDLE_CONFIGURACION = "Conf";
	public static final ResourceBundle RESOURCE_CONFIGURACION = ResourceBundle.getBundle(BUNDLE_CONFIGURACION, new Locale("es","Mx"));
	
	public static final String ICON_INFO = "ui-icon ui-icon-info";
	public static final String ICON_ALERT = "ui-icon ui-icon-alert";
	public static final String DIV_INFO = "ui-state-highlight ui-corner-all";
	public static final String DIV_ALERT = "ui-state-error ui-corner-all";
	
    public static final String WS_LOGIN = RESOURCE_CONFIGURACION.getString("WS_LOGIN");
    public static final String WS_MONTO_BOLSON = RESOURCE_CONFIGURACION.getString("WS_MONTO_BOLSON");
    public static final String WS_AMPLIAR_BOLSON = RESOURCE_CONFIGURACION.getString("WS_AMPLIAR_BOLSON");
    public static final String WS_BLOQUEO_USUARIO = RESOURCE_CONFIGURACION.getString("WS_BLOQUEO_USUARIO");
    public static final String WS_DESBLOQUEO_USUARIO = RESOURCE_CONFIGURACION.getString("WS_DESBLOQUEO_USUARIO");
    public static final String WS_BUSQUEDA_BOLSON = RESOURCE_CONFIGURACION.getString("WS_BUSQUEDA_BOLSON");
    public static final String WS_BLOQUEO_BOLSON = RESOURCE_CONFIGURACION.getString("WS_BLOQUEO_BOLSON");
    public static final String WS_DESBLOQUEO_BOLSON = RESOURCE_CONFIGURACION.getString("WS_DESBLOQUEO_BOLSON");

    public static final String SUCCESS_MSG = "Operación exitosa";
    public static final String FAIL_MSG = "Operación no exitosa";
    public static final String OK = "OK";
    
    public static final String ACTIVITY_LOG_BEAN = RESOURCE_CONFIGURACION.getString("ACTIVITY_LOG_BEAN");
    
    public static final String CVEAPLB = "APBL";
    public static final String CVEBLUS = "BLUS";
    public static final String CVEBLBL = "BLBL";
    public static final String CVEDLUS = "DLUS";
    public static final String CVEDLBL = "DLBL";
    

}
