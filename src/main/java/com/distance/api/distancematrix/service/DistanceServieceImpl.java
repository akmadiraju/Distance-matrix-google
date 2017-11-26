package com.distance.api.distancematrix.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.distance.api.distancematrix.model.DistanceElements;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

@Service
public class DistanceServieceImpl implements DistanceService {
		
	private static final String API_KEY = "AIzaSyDu437HKDg6-w0SK0lB1aKIXoRFH0fZ_0A";


	@Override
	public DistanceElements getDistance(String origin, String destination, String apiKey) {
		// TODO Auto-generated method stub
		DistanceMatrix distance = getDistanceFromMatrix(origin, destination);
		distance.getClass();
		return null;
	}
	
	public DistanceMatrix getDistanceFromMatrix(String origin, String destination) {
		GeoApiContext geoApiContext = new GeoApiContext.Builder()
				.apiKey(API_KEY)
			    .build();
		
		
		DistanceMatrixApiRequest distanceRequest = new DistanceMatrixApiRequest(geoApiContext);
		try {
			DistanceMatrix matrix = distanceRequest.origins(origin)
									.destinations(destination)
									.mode(TravelMode.DRIVING)
									.avoid(RouteRestriction.FERRIES)
									.language("English")
									.await();
			return matrix;
		} catch (ApiException | InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
}
