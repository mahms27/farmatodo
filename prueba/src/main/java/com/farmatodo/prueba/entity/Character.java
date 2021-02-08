package com.farmatodo.prueba.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="personajes")
public class Character {
	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
	private String name;
	
    @Column(name = "species")
	private String species;
	
    @Column(name = "gender")
	private String gender;
	
    @Column(name = "images")
	private String image;
	
	
    @JoinColumn(name = "location", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Location location;

	public String getName() {
		return name;
	}

	public String getSpecies() {
		return species;
	}

	public String getGender() {
		return gender;
	}

	public String getImage() {
		return image;
	}


	public Location getLocation() {
		return location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	
}
