package com.distance.api.distancematrix.controller.v1;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import com.distance.api.distancematrix.model.DistanceElements;
import com.distance.api.distancematrix.model.DriveModeRequest;
import com.distance.api.distancematrix.service.DistanceService;


@Component
@Path("/distance")
@Produces(MediaType.APPLICATION_JSON)
public class DistanceResource {
	
	
	@Inject
	private DistanceService distanceService;
	
	
	@GET
	@Path("/health")
	@Produces(MediaType.APPLICATION_JSON	)
	public Response healthCheck() {
		
		ResponseBuilder builder = responseBuilder(Status.OK, null);
		
		return builder.build();
		
	}
	
	
	@GET
	@Path("/origin/{origin}/destination/{destination}")
	public Response getDistance(@PathParam(value = "origin") String origin,
			@PathParam(value = "destination") String destination,
			@HeaderParam(value = "ApiKey") String apiKey) {
		if (isApiKeyValid(apiKey)) {
			DistanceElements distanceElements = distanceService.getDistanceMatrix(origin, destination );
			ResponseBuilder builder = responseBuilder(Status.OK, distanceElements);
			return builder.build();
		}else {
			ResponseBuilder builder = responseBuilder(Status.FORBIDDEN, null );
			return builder.build();
		}
	}
	
//	@POST
//	@Path("/origin/{origin}/destination/{destination}")
//	public Response getDistanceMatrix(@PathParam(value="origin") String origin,
//			@PathParam(value = "destination") String destination,
//			DriveModeRequest driveModeReq,
//			@HeaderParam(value = "ApiKey") String apiKey){
//		
//		if (isApiKeyValid(apiKey)) {
//			
//		}else {
//			ResponseBuilder builder = responseBuilder(Status.FORBIDDEN, null);
//		}
//		return null;	
//	}
	
	
	private Response.ResponseBuilder responseBuilder(Status status, Object responseObject) {
		
		return Response.status(status).entity(responseObject);
	}
	
	private boolean isApiKeyValid(String apiKey) {
		return apiKey != null && !apiKey.isEmpty();
	}

}
