package com.farmatodo.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lugares")
public class Location{

	
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	private String type;
	
	private String dimension;

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getDimension() {
		return dimension;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	
}
