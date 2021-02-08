package com.farmatodo.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmatodo.prueba.entity.Episode;


public interface EpisodeRepository extends JpaRepository<Episode, Integer>{
	
	Episode getByEpisode(Integer episode);

}
