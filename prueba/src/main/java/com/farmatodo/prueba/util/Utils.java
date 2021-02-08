package com.farmatodo.prueba.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.farmatodo.prueba.dto.Response;


public class Utils {
	
	private static Logger logger = LoggerFactory.getLogger(Utils.class);
	
	public static Response convertJSONtoObject(String json) {

		Response resp = null;

		try {

			ObjectMapper mapper = new ObjectMapper();
			resp = mapper.readValue(json, Response.class);

		} catch (Exception e) {
			logger.error("error method convertJSONtoObject ", e);
		}

		return resp;

	}
	
	public static List<Object> getObjectListFromJson(String json) throws JsonParseException, JsonMappingException, IOException {
		
		List<Object> resp = null;

		if(json != null && !json.isEmpty()) {
			
			ObjectMapper mapper = new ObjectMapper();
			resp = mapper.readValue(json, new TypeReference<List<Object>>(){});
		}

		return resp;
	}
	
	public static String generateCustomList(List<String> param ) {
		
		List<String> list = new ArrayList<>();
		StringBuffer content = new StringBuffer();
		
		for (String p : param) {		
			String[] array = p.split("/");
			list.add(array[5]);		
		}
		
		content.append(String.join(",", list) + System.getProperty("line.separator"));
		
		return content.toString().trim();
	}
	
	public static Response getError(String jsonObject) {
		
		Response respError = new Response();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			respError = mapper.readValue(jsonObject.toString(), Response.class);
			
		} catch (JsonProcessingException e) {
			
			logger.error("error method getError ", e);
			
		}
		
		return respError;
	}
	
	public static int[] getDigitNumber(int number){
		
		int digit = 0;
		int[] numbers = new int[Integer.toString(number).length()];
		
		while ( number>0 ){
			numbers[digit] = number%10;
			number = number/10;  
			digit++;
		}
		
		return numbers;
		
	}

}
