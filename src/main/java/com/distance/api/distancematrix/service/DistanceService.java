package com.distance.api.distancematrix.service;

import com.distance.api.distancematrix.model.DistanceElements;

public interface DistanceService {


	DistanceElements getDistanceMatrix(String origin, String destination, String apiKey);
	
	

}
