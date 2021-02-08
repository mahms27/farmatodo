package com.farmatodo.prueba.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
	
    @JsonProperty("error")
    private String error;
    
    @JsonProperty("numbers")
    private List<NumbersDTO> numbers;
    
    @JsonProperty("result")
    private Integer result;
  
	
	public String getError() {
		return error;
	}


	public List<NumbersDTO> getNumbers() {
		return numbers;
	}


	public Integer getResult() {
		return result;
	}


	public void setError(String error) {
		this.error = error;
	}


	public void setNumbers(List<NumbersDTO> numbers) {
		this.numbers = numbers;
	}


	public void setResult(Integer result) {
		this.result = result;
	}


	public Response() {
		super();
	}
    

}
