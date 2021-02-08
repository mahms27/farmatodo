package com.farmatodo.prueba.mapper;

import org.springframework.stereotype.Service;

import com.farmatodo.prueba.dto.CharacterDTO;
import com.farmatodo.prueba.dto.CharacterWSDTO;
import com.farmatodo.prueba.dto.LocationDTO;


@Service
public class CharacterMapperImpl implements CharacterMapper{

	@Override
	public CharacterDTO convertResponseToDTO(CharacterWSDTO c, LocationDTO l) {
		
		CharacterDTO dto = new CharacterDTO();
		LocationDTO location = new LocationDTO();
		
		dto.setName(c.getName());
		dto.setSpecies(c.getSpecies());
		dto.setGender(c.getGender());
		dto.setImage(c.getImage());
		location.setDimension(l.getDimension());
		location.setName(l.getName());
		location.setType(l.getType());
		dto.setLocation(location);
		
		
		return dto;
	}

}
