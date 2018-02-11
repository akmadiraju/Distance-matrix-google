package com.ak.travel.travelmatrix.service;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.travel.travelmatrix.exception.InvalidRequestException;
import com.ak.travel.travelmatrix.exception.UnknownServiceException;
import com.ak.travel.travelmatrix.model.TravelMatrixResponse;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.TravelMode;

@Service
public class TravelMatrixServiceImpl  implements TravelMatrixService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelMatrixServiceImpl.class);
	
	@Autowired
	private GeoApiContext geoApiContext;

	@Override
	public TravelMatrixResponse getTravelDetails(String origin, String destination) {
		TravelMatrixResponse response = new TravelMatrixResponse();
		DistanceMatrix distanceElements = distanceMatrix(origin, destination);
		
		if(StringUtils.isEmpty(distanceElements.originAddresses[0])){
			throw new InvalidRequestException();
		}else if (StringUtils.isEmpty(distanceElements.destinationAddresses[0])) {
			throw new InvalidRequestException();
		}
		DistanceMatrixElement matrixRows = distanceElements.rows[0].elements[0];
		
		response.setDistance(matrixRows.distance.toString());
		response.setDuration(matrixRows.duration.toString());
		
		
		return response;
	}
	
	private DistanceMatrix distanceMatrix(String origin, String destination){
		
		DistanceMatrixApiRequest matrixElements = new DistanceMatrixApiRequest(geoApiContext);
		
		try {
			return matrixElements.origins(origin)
						.destinations(destination)
						.mode(TravelMode.DRIVING)
						.language("English")
						.await();
		} catch (ApiException | InterruptedException | IOException e) {
			LOGGER.error(e.getMessage());
			throw new UnknownServiceException();
			
		}
		
	}

}
