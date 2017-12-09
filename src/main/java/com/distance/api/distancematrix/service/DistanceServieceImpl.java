package com.distance.api.distancematrix.service;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

import com.distance.api.distancematrix.model.DistanceElements;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.Distance;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;

@Service
public class DistanceServieceImpl implements DistanceService {
	
	
	@Inject
	private GeoApiContext geoApiContext;
	
	private DistanceMatrixElement matrixRows;
	

	@Override
	public DistanceElements getDistance(String origin, String destination, String apiKey) {
		// TODO Auto-generated method stub
		DistanceMatrix distance = getDistanceFromMatrix(origin, destination);
		matrixRows = distance.rows[0].elements[0];
		if (matrixRows == null ) {
			throw new InternalServerErrorException("An Unknown Error Occured");
		}
		
		DistanceElements distanceElements = new DistanceElements();
		distanceElements.setDistance(matrixRows.distance.humanReadable);
		distanceElements.setDuration(matrixRows.duration.humanReadable);
		
		return distanceElements;
	}
	
	public DistanceMatrix getDistanceFromMatrix(String origin, String destination) {
		try {
			DistanceMatrixApiRequest distanceRequest = new DistanceMatrixApiRequest(geoApiContext);
			return distanceRequest.origins(origin)
					.destinations(destination)
					.mode(TravelMode.DRIVING)
					.avoid(RouteRestriction.FERRIES)
					.language("English")
					.await();
		} catch (ApiException | InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
