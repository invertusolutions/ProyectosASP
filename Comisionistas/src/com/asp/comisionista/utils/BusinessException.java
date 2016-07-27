
package com.asp.comisionista.utils;

// TODO: Auto-generated Javadoc
/**
 * La Clase ExcepcionGeneral es usada como contenedor para tener una excepcion personalizada con mensaje y codigo de error.
 */
public class BusinessException extends Exception {

    /** La Constante serialVersionUID. */
    private static final long serialVersionUID = 4444162347493019252L;
    
    /** La variable code que contiene el codigo de error dependiendo de la excepcion.  */
    private String code = "";
    
    /** La variable message contiene el mensaje que sera desplegado al usuario. */
    private String message = "";

    /**
     * Contructor de excepcion general para recibi el mensaje y el codigo de error.
     *
     * @param pstrCode el parametro pstr code con el codigo de error
     * @param pstrMessage el parametro pstr message con el mensaje de error
     * @param e el parametro e
     */
    public BusinessException(String pstrCode, String pstrMessage, Exception e) {
        this.code = pstrCode;
        this.message = pstrMessage;
        this.setStackTrace(e.getStackTrace());
    }

    /**
     * Coloca el valor de code.
     *
     * @param code es el nuevo valor de code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Coloca el valor de message.
     *
     * @param message es el nuevo valor de message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Obtiene el valor de la variable de mensaje.
     *
     * @return el mensaje de error.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Obtiene el valor de la variable code.
     *
     * @return el code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Metodo sobrescrito para escribir una descripcion del objeto
     *
     * @return una descripcion del codigo y el mensaje de error
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" Code: ").append(this.code);
        sb.append(" Message: ").append(this.message);
        return sb.toString();
    }
}
