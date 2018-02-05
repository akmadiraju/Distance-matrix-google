package com.distance.api.distancematrix.controller.v1;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.distance.api.distancematrix.model.DistanceElements;
import com.distance.api.distancematrix.service.DistanceService;



@Named
@Path("/distance")
@Produces("application/json")
public class DistanceResource {
	
	private static org.apache.log4j.Logger LOGGER = 
				org.apache.log4j.Logger.getLogger(DistanceResource.class);
	
	

	@Inject
	private DistanceService distanceService;
	
	
	@GET
	@Path("/health")
	@Produces("application/json")
	public Response healthCheck() {
		
		ResponseBuilder builder = responseBuilder(Status.OK, null);
		
		return builder.build();
		
	}
	
	
	@GET
	@Path("/origin/{origin}/destination/{destination}")
	@Produces("application/json")
	public Response getDistance(@PathParam(value = "origin") String origin,
			@PathParam(value = "destination") String destination,
			@HeaderParam(value = "ApiKey") String apiKey) {
		
			DistanceElements distanceElements = distanceService.getDistanceMatrix(origin, destination, apiKey );
			ResponseBuilder builder = responseBuilder(Status.OK, distanceElements);
			LOGGER.info("apikey is not provided");
			return builder.build();
			

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
