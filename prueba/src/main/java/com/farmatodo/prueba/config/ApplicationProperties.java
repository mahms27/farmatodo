package com.farmatodo.prueba.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:custom.properties", encoding="UTF-8")

@ConfigurationProperties(prefix = "custom", ignoreUnknownFields = false)
public class ApplicationProperties{
	
	@Value("${com.farmatodo.uri.service.episode}")
	private String uriEpisode;
	
	@Value("${com.farmatodo.uri.service.character}")
	private String uriCharacter;
	
	@Value("${com.farmatodo.uri.service.location}")
	private String uriLocation;
	
	@Value("${com.farmatodo.text.unknown}")
	private String unknown;
	
	@Value("${com.farmatodo.text.happy.number.service.message.error}")
	private String msgErrorHappyNumberService;
	
	
	public String getUriEpisode() {
		return uriEpisode;
	}



	public String getUriCharacter() {
		return uriCharacter;
	}



	public String getUriLocation() {
		return uriLocation;
	}



	public void setUriEpisode(String uriEpisode) {
		this.uriEpisode = uriEpisode;
	}



	public void setUriCharacter(String uriCharacter) {
		this.uriCharacter = uriCharacter;
	}



	public void setUriLocation(String uriLocation) {
		this.uriLocation = uriLocation;
	}
	
	

	public String getUnknown() {
		return unknown;
	}



	public void setUnknown(String unknown) {
		this.unknown = unknown;
	}



	public String getMsgErrorHappyNumberService() {
		return msgErrorHappyNumberService;
	}



	public void setMsgErrorHappyNumberService(String msgErrorHappyNumberService) {
		this.msgErrorHappyNumberService = msgErrorHappyNumberService;
	}



	@Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }



}
