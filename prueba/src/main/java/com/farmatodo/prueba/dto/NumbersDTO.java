package com.farmatodo.prueba.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class NumbersDTO {
	
	@JsonProperty("number")
	private Integer number;
	
	
	@JsonProperty("isHappy")
	private Boolean isHappy;
	
	@JsonProperty("message")
	private String message;

}
