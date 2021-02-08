package com.farmatodo.prueba.mapper;

import com.farmatodo.prueba.dto.CharacterDTO;
import com.farmatodo.prueba.dto.CharacterWSDTO;
import com.farmatodo.prueba.dto.LocationDTO;

public interface CharacterMapper {
	
	CharacterDTO convertResponseToDTO(CharacterWSDTO c, LocationDTO l);

}
