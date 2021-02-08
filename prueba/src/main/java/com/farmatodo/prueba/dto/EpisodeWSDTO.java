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
public class EpisodeWSDTO extends Response {
	
	
	@JsonProperty("id")
	private Integer Id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("air_date")
	private String airDate;
	
	@JsonProperty("episode")
	private String episode;
	
	@JsonProperty("characters")
	private List<String> characters;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("created")
	private String created;

	public EpisodeWSDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
