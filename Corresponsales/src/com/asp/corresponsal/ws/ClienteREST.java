
package com.asp.corresponsal.ws;

import com.asp.corresponsal.utils.ConstantesUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


/**
 *
 * @author Administrador
 */
public class ClienteREST {
	private final String ERROR_HTTP = "Codigo de error HTTP: ";
	private Client client;
	
	public ClienteREST(){
		iniClient();
	}
    
    public ResponseWS login(String user, String pwd) {
        WebResource webResource = client.resource(ConstantesUtil.WS_LOGIN).path(user).path(pwd);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new ResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new ResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		ResponseWS output = response.getEntity(ResponseWS.class);
        return output;
    }
    public BolsonResponseWS montoBolson(String cuenta) {
        WebResource webResource = client.resource(ConstantesUtil.WS_MONTO_BOLSON).path(cuenta);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new BolsonResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new BolsonResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		BolsonResponseWS output = response.getEntity(BolsonResponseWS.class);
        return output;
    }
    public ResponseWS ampliarBolson(String cuenta, String saldo) {
        WebResource webResource = client.resource(ConstantesUtil.WS_AMPLIAR_BOLSON).path(cuenta).path(saldo);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new ResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new ResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		ResponseWS output = response.getEntity(ResponseWS.class);
        return output;
    }
    public ResponseWS bloqueaUsr(String user, String corresponsal) {
        WebResource webResource = client.resource(ConstantesUtil.WS_BLOQUEO_USUARIO).path(user).path(corresponsal);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new ResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new ResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		ResponseWS output = response.getEntity(ResponseWS.class);
        return output;
    }
    public ResponseWS desbloqueaUsr(String user, String corresponsal) {
        WebResource webResource = client.resource(ConstantesUtil.WS_LOGIN).path(user).path(corresponsal);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new ResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new ResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		ResponseWS output = response.getEntity(ResponseWS.class);
        return output;
    }
    public DetalleBolsonResponseWS findBolson(String user, String valor, String criterio) {
        WebResource webResource = client.resource(ConstantesUtil.WS_LOGIN).path(user).path(valor).path(criterio);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new DetalleBolsonResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new DetalleBolsonResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		DetalleBolsonResponseWS output = response.getEntity(DetalleBolsonResponseWS.class);
        return output;
    }
    public ResponseWS bloqueaBolson(String user, String id) {
        WebResource webResource = client.resource(ConstantesUtil.WS_LOGIN).path(user).path(id);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new DetalleBolsonResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new ResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		ResponseWS output = response.getEntity(ResponseWS.class);
        return output;
    }
    public ResponseWS desbloqueaBolson(String user, String id) {
        WebResource webResource = client.resource(ConstantesUtil.WS_LOGIN).path(user).path(id);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new DetalleBolsonResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new ResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		ResponseWS output = response.getEntity(ResponseWS.class);
        return output;
    }
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	public void iniClient(){
    	ClientConfig clientConfig = new DefaultClientConfig();
    	clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    	client = Client.create(clientConfig);
	}
    

}
