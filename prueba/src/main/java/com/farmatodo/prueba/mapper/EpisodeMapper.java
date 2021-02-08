package com.farmatodo.prueba.mapper;

import com.farmatodo.prueba.dto.EpisodeDTO;
import com.farmatodo.prueba.entity.Episode;

public interface EpisodeMapper {

	
    EpisodeDTO convertToDto(Episode episode);
    
    Episode toEntity(EpisodeDTO episodeDTO);
}
