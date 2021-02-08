package com.farmatodo.prueba.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmatodo.prueba.repository.EpisodeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.farmatodo.prueba.config.ApplicationProperties;
import com.farmatodo.prueba.dto.CharacterDTO;
import com.farmatodo.prueba.dto.CharacterWSDTO;
import com.farmatodo.prueba.dto.EpisodeDTO;
import com.farmatodo.prueba.dto.EpisodeWSDTO;
import com.farmatodo.prueba.dto.LocationDTO;
import com.farmatodo.prueba.dto.NumbersDTO;
import com.farmatodo.prueba.dto.Response;
import com.farmatodo.prueba.entity.Episode;
import com.farmatodo.prueba.mapper.CharacterMapper;
import com.farmatodo.prueba.mapper.EpisodeMapperImpl;
import com.farmatodo.prueba.mapper.LocationMapper;
import com.farmatodo.prueba.util.ServiceLocator;
import com.farmatodo.prueba.util.Utils;

@Service
@Transactional
public class FarmatodoServicesImpl implements FarmatodoServices{

	
	private static Logger logger = LoggerFactory
			.getLogger(FarmatodoServicesImpl.class);

	@Autowired
	private ApplicationProperties prop;

	@Autowired
	private ServiceLocator service;
	
	@Autowired
	private CharacterMapper cMapper;
	
	@Autowired
	private LocationMapper lMapper;
	
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
	private EpisodeMapperImpl mapper;
    
    @Autowired
	private EpisodeRepository eRepo;
    
	
	@Override
	public Response getEpisode(Integer ep) {
		return eRepo.getByEpisode(ep) != null ? mapper.convertToDto(eRepo.getByEpisode(ep)): getEpisodeWS(ep);
	}
	
	private  Response getEpisodeWS(Integer ep) {
		
		EpisodeDTO resp = new EpisodeDTO();
		JSONObject jsonObject = null;
		EpisodeWSDTO episode = new  EpisodeWSDTO();
		ObjectMapper mapper = new ObjectMapper();
		List<CharacterDTO> list = new ArrayList<>();
		
		
		try {
			jsonObject = service.callServiceJSON(prop.getUriEpisode().replace("{episode}", ep.toString()));
			
			episode = mapper.readValue(jsonObject.toString(), EpisodeWSDTO.class);
									
			getCharacter( episode ).stream().forEach( (c) -> { 
				list.add(cMapper.convertResponseToDTO(c, getLocation(c.getLocation().getUrl())));
			} );
			
			resp.setEpisode(episode.getId());
			resp.setEpisodeName(episode.getName());
			resp.setCharacters(list);
			
			
			save(resp);
			
			
		} catch (Exception e) {
			
			return Utils.getError(jsonObject.toString());
			
		}
		
		return resp;
	}


	private List<CharacterWSDTO> getCharacterWS(String characters) {
		List<CharacterWSDTO> reply = new ArrayList<>();
		try {
			String resp = service.callServicesString(prop.getUriCharacter().replace("{characters}", characters));
			
			ObjectMapper mapper = new ObjectMapper();
			reply = mapper.convertValue(Utils.getObjectListFromJson(resp), new TypeReference<List<CharacterWSDTO>>() { });
		} catch (Exception e) {
			logger.error("error method getCharacter  " , e);
		}
		
		return reply;
	}

	
	private LocationDTO getLocation(String apiUrl) {
		return apiUrl.equalsIgnoreCase("") ? getLocationWS(apiUrl): lMapper.createLocationUnknown();
	}

	private  LocationDTO getLocationWS(String apiUrl) {
		
		LocationDTO resp = new  LocationDTO();
		
		try {
			
			JSONObject jsonObject = service.callServiceJSON(apiUrl);
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			resp = mapper.readValue(jsonObject.toString(), LocationDTO.class);
			
		} catch (Exception e) {
			
			logger.error("error method getLocation ", e);
			
		}
		
		return resp;
	}
	
	private List<CharacterWSDTO> getCharacter( EpisodeWSDTO episode ) {
		return getCharacterWS(Utils.generateCustomList(episode.getCharacters()));
	}

	private EpisodeDTO save(EpisodeDTO eDTO) throws Exception {

		EpisodeDTO dto = null;
		
		try {
			
			Episode eVo = mapper.toEntity(eDTO);
			em.persist(eVo);
			dto = mapper.convertToDto(eVo);
			
		} catch (Exception e) {			
			logger.error("error method save  ", e);
		}
		
		return dto;
		
	}
	
	@Override
	public Response getNumberList(List<Integer> list) {
		
		Response resp =  new Response();
		List<NumbersDTO> numbers =  new ArrayList<>();
		
		list.stream().forEach( (n) -> { 
			numbers.add(validateHappyNumber(n));
		} );
		
		resp.setNumbers(numbers);
		
		return resp;
	}
	
	private NumbersDTO validateHappyNumber(Integer n){
		
		NumbersDTO number = new NumbersDTO();
		
		int add = 0;
		Set<Integer> processed = new HashSet<Integer>();
		boolean repeat = false;
		
		number.setNumber(n);
		int[] numbers = Utils.getDigitNumber(n);
		
		while ((add!=1) && !(repeat)) {
			
			add = 0;
			for (int i=0;i<numbers.length;i++)
				add += Math.pow(numbers[i],2);				
			numbers =  Utils.getDigitNumber(add);
			
			if (processed.contains(new Integer(add))) 
				repeat = true;
			else
				processed.add(new Integer(add));
			
		}
		
		number.setIsHappy(repeat == true ? false:true);

		return number;
		
	}

	@Override
	public Response addNaturalNumber(Integer n) throws Exception {
		
		Integer num = 1;
		Integer add = 0; 
		Response res = new Response();
		
		if(n >=0) {
			
			while (num <= n) {
				
	            add = add + num;
	            num++;
	            
	        }
			
			res.setResult(add);
			
		}else {
			throw new Exception("No se permiten numeros negativos.");
		}
		
		return res;
	}



}
