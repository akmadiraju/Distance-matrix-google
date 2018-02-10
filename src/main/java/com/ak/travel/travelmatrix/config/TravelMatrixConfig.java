package com.ak.travel.travelmatrix.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.google.maps.GeoApiContext;

@Configuration
@PropertySource(value = {"application.properties"})
public class TravelMatrixConfig {
	
	
	@Value("${remote-service-apikey}")
	private String remoteServiceKey;
	
	@Bean
	public GeoApiContext geoApiContext(){
		GeoApiContext geoApiContext = new GeoApiContext.Builder()
				.apiKey(remoteServiceKey)
				.build();
		return geoApiContext;
	}

}
