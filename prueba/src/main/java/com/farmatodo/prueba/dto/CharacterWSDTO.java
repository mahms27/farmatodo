package com.farmatodo.prueba.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CharacterWSDTO {

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("species")
	private String species;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("origin")
	private ObjectDTO origin;
	
	@JsonProperty("location")
	private ObjectDTO location;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("episode")
	private List<String> episode;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("created")
	private String created;
}
