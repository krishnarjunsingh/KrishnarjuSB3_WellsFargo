package com.wellsfargo.interviewtracker.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	//For non Spring application, we can create instance by using new keyword
	ModelMapper modelMapper = new ModelMapper();
}
