package com.farmatodo.prueba.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CharacterRatingKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "episode_id")
    Long episodeId;

    @Column(name = "character_id")
    Long characterId;

	public Long getEpisodeId() {
		return episodeId;
	}

	public Long getCharacterId() {
		return characterId;
	}

	public void setEpisodeId(Long episodeId) {
		this.episodeId = episodeId;
	}

	public void setCharacterId(Long characterId) {
		this.characterId = characterId;
	}

	public CharacterRatingKey() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
