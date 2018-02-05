package com.distance.api.distancematrix.service;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import com.distance.api.distancematrix.exception.DistanceMatrixException;
import com.distance.api.distancematrix.model.DistanceElements;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixElementStatus;
import com.google.maps.model.TravelMode;

@Named
public class DistanceServieceImpl implements DistanceService {
	
	
	@Inject
	private GeoApiContext geoApiContext;
	

	
	private DistanceMatrixElement matrixRows;
	

	@Override
	public DistanceElements getDistanceMatrix(String origin, String destination, String apiKey) {
		// TODO Auto-generated method stub
		DistanceMatrix distance = getDistanceFromMatrix(origin, destination,  apiKey);
		matrixRows = distance.rows[0].elements[0];
		
		if (matrixRows.status == DistanceMatrixElementStatus.NOT_FOUND ) {
			throw new DistanceMatrixException("Invalid data in the request");
		}
		
		DistanceElements distanceElements = new DistanceElements();
		distanceElements.setDistance(matrixRows.distance.humanReadable);
		distanceElements.setDuration(matrixRows.duration.humanReadable);
		
		return distanceElements;
	}
	
	public DistanceMatrix getDistanceFromMatrix(String origin, String destination,
			String apiKey) {
		

		try {
			DistanceMatrixApiRequest distanceRequest = new DistanceMatrixApiRequest(geoApiContext);
			return distanceRequest.origins(origin)
					.destinations(destination)
					.mode(TravelMode.DRIVING)
					.avoid(RouteRestriction.FERRIES)
					.language("English")
					.await();
		} catch (ApiException | InterruptedException | IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
