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
public class EpisodeDTO extends Response{
	
	
	@JsonProperty("episode")
	private Integer episode;
	
	@JsonProperty("episodeName")
	private String episodeName;
	
	@JsonProperty("characters")
	private List<CharacterDTO> characters;

}
