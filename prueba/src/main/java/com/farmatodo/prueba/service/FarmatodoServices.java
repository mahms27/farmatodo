package com.farmatodo.prueba.service;

import java.util.List;

import com.farmatodo.prueba.dto.Response;

public interface FarmatodoServices {

	Response getEpisode(Integer e);
	
	Response getNumberList( List<Integer> list);
	
	Response addNaturalNumber(Integer n) throws Exception;
		
}
