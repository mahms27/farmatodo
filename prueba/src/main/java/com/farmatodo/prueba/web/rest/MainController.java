package com.farmatodo.prueba.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.farmatodo.prueba.dto.Response;
import com.farmatodo.prueba.exception.EntityNotFoundException;
import com.farmatodo.prueba.service.FarmatodoServices;

@RestController
@RequestMapping("/api")
public class MainController {
	
	private static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private FarmatodoServices service;
	
	
	@GetMapping("/farmatodo/rickandmorty/getepisode/{episode}")
	@ResponseBody
    public ResponseEntity<Response> getEpisode(@PathVariable Integer episode) {
		
		logger.info(" init method getEpisode episode {0}",episode);
		return new ResponseEntity<>(service.getEpisode(episode), HttpStatus.OK);		
	}
	
	@PostMapping("/farmatodo/getHappyNumbers")
	@ResponseBody
    public ResponseEntity<Response> getHappyNumbers( @RequestBody List<Integer> list) throws EntityNotFoundException{
		
		return new ResponseEntity<>(service.getNumberList(list), HttpStatus.OK);
		
	}
	
	@GetMapping("/farmatodo/addnaturalnumber/{number}")
	@ResponseBody
    public ResponseEntity<Response> addNaturalNumber(@PathVariable Integer number) {
		
		logger.info(" init method addNaturalNumber number {0}",number);
		Response resp = new Response();
		
		try {
			resp = service.addNaturalNumber(number);
		} catch (Exception e) {			
			resp.setError(e.getMessage());
			return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		}	
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
}
