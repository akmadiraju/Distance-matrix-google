package com.distance.api.distancematrix.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.distance.api.distancematrix.controller.v1.DistanceResource;

@Configuration
public class JerseyConfig  extends ResourceConfig{
	
	public JerseyConfig() {
		register(DistanceResource.class);
	}

}
