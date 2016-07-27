
package com.asp.comisionista.ws;

import com.asp.comisionista.utils.ConstantesUtil;
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
    public ResponseWS changePwd(String user, String pwd, String newPwd) {
        WebResource webResource = client.resource(ConstantesUtil.WS_CAMBIO_PASS).path(user).path(pwd).path(newPwd);
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
    public BolsonResponseWS findBolson(String user) {
        WebResource webResource = client.resource(ConstantesUtil.WS_SALDO_CORRESPONSAL).path(user);
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
    public NumAutResponseWS autToken(String user, String pwd) {
        WebResource webResource = client.resource(ConstantesUtil.WS_AUT_TOKEN).path(user).path(pwd);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new NumAutResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new NumAutResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		NumAutResponseWS output = response.getEntity(NumAutResponseWS.class);
        return output;
    }
    public TokenResponseWS readToken(String user, String numAut) {
        WebResource webResource = client.resource(ConstantesUtil.WS_LOGIN).path(user).path(numAut);
        ClientResponse response = null;
        
        try {
        	response = webResource.get(ClientResponse.class);
		} catch (Exception e) {
			return new TokenResponseWS("No se pudo conectar con el servicio");
		}

		if (response.getStatus() != 200) {
		   return new TokenResponseWS(ERROR_HTTP	+ response.getStatus());
		}

		TokenResponseWS output = response.getEntity(TokenResponseWS.class);
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
