package com.farmatodo.prueba.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmatodo.prueba.config.ApplicationProperties;
import com.farmatodo.prueba.dto.LocationDTO;

@Service
public class LocationMapperImp implements LocationMapper {

	
	@Autowired
	private ApplicationProperties prop;
	
	@Override
	public LocationDTO createLocationUnknown() {
		
		LocationDTO l = new LocationDTO();
		
		l.setDimension(prop.getUnknown());
		l.setName(prop.getUnknown());
		l.setType(prop.getUnknown());
		
		return l;
	}

}
