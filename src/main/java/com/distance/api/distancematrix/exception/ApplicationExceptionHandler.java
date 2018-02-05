package com.distance.api.distancematrix.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.distance.api.distancematrix.model.ErrorMessage;


@Provider
public class ApplicationExceptionHandler implements ExceptionMapper<DistanceMatrixException>{

	@Override
	public Response toResponse(DistanceMatrixException ex) {
		ErrorMessage message = new ErrorMessage(400,ex.getMessage());
		return Response.status(Status.BAD_REQUEST)
				.entity(message)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

	


	

}
