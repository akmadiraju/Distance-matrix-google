package com.ak.travel.travelmatrix.service;

import com.ak.travel.travelmatrix.model.TravelMatrixResponse;

public interface TravelMatrixService {
	
	public TravelMatrixResponse getTravelDetails(String origin, String destination);
	
	
}
