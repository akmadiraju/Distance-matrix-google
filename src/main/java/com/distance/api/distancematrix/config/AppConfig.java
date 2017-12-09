package com.distance.api.distancematrix.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.google.maps.GeoApiContext;

@Configuration
@PropertySource({"application.properties"})
public class AppConfig {
	
	@Value("${remote-service-apikey}")
	private String API_KEY;
	
	@Bean(name="geoApiContext")
	public GeoApiContext geoApiContext(){
		GeoApiContext geoApiContext = new GeoApiContext.Builder()
				.apiKey(API_KEY)
			    .build();
		
		return geoApiContext;
	}
	

	

	



}
