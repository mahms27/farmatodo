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
public class CharacterDTO {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("species")
	private String species;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("location")
	private LocationDTO location;
}
