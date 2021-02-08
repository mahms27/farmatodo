package com.farmatodo.prueba.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.farmatodo.prueba.dto.EpisodeDTO;
import com.farmatodo.prueba.entity.Episode;



@Service
public class EpisodeMapperImpl implements EpisodeMapper{

	@Override
	public EpisodeDTO convertToDto(Episode episode) {
		
		EpisodeDTO episodeDTO  = null;
		
		if(episode != null) {
			
			ModelMapper modelMapper = new ModelMapper();
			episodeDTO = modelMapper.map(episode, EpisodeDTO.class);
			
		}
			
		return episodeDTO;
	}

	@Override
	public Episode toEntity(EpisodeDTO episodeDTO) {
		
		ModelMapper modelMapper = new ModelMapper();
		Episode episode = modelMapper.map(episodeDTO, Episode.class);
		
		return episode;
		
	}

}
