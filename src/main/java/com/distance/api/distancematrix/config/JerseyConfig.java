package com.distance.api.distancematrix.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.distance.api.distancematrix.controller.v1.DistanceResource;

@Component
public class JerseyConfig  extends ResourceConfig{
	
	public JerseyConfig() {
		register(DistanceResource.class);
	}

}
