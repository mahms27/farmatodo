package com.farmatodo.prueba.entity;

import java.util.List;

import javax.persistence.*;

import com.farmatodo.prueba.entity.Character;

@Entity
@Table(name="episodios")
public class Episode {
	
	
    @Id
    @Column(name = "episode")
	private Integer episode;
	
	private String episodeName;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "personajes_episodio", 
    joinColumns = @JoinColumn(name = "episode_id"), 
    inverseJoinColumns = @JoinColumn(name = "character_id"))
	private List<Character> characters;


	public Integer getEpisode() {
		return episode;
	}


	public String getEpisodeName() {
		return episodeName;
	}


	public List<Character> getCharacters() {
		return characters;
	}


	public void setEpisode(Integer episode) {
		this.episode = episode;
	}


	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}


	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
	
	
}
