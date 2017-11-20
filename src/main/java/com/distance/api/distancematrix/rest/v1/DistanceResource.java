package com.distance.api.distancematrix.rest.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

@Component
@Path("/distance")
@Produces(MediaType.APPLICATION_JSON)
public class DistanceResource {
	
	
	@GET
	@Path("/health")
	@Produces(MediaType.APPLICATION_JSON	)
	public Response healthCheck() {
		
		ResponseBuilder builder = responseBuilder(Status.OK, null);
		
		return builder.build();
		
	}
	
	
	private Response.ResponseBuilder responseBuilder(Status status, Object responseObject) {
		
		return Response.status(status).entity(responseObject);
		
		
	}

}
