package com.farmatodo.prueba.util;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import com.farmatodo.prueba.exception.ServiceException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


@Component
public class ServiceLocator {

	
	public JSONObject callServiceJSON(String apiURL) throws Exception {
		
		String responseJson = "";

		Client client = Client.create();
		WebResource webResource = client
				.resource(apiURL);

		ClientResponse response = webResource
				.accept("application/json")
				.get(ClientResponse.class);

		if(response.getStatus() < 200 && response.getStatus() >= 300 && response.getStatus() != 500) {
			throw new ServiceException("Unexpected response status: " + response.getStatus());
		}

		responseJson = response.getEntity(String.class);
		
		return new JSONObject(responseJson);
		
	}
	
	public String callServicesString(String apiUrl ) throws ServiceException {

		String responseJson = "";

		Client client = Client.create();
		WebResource webResource = client
				.resource(apiUrl);


		ClientResponse response = webResource
				.accept("application/json")			
				.get(ClientResponse.class);

		if(response.getStatus() < 200 && response.getStatus() >= 300 && response.getStatus() != 500) {
			throw new ServiceException("Unexpected response status: " + response.getStatus());
		}

		responseJson = response.getEntity(String.class);

		return responseJson;

	}
	
}
