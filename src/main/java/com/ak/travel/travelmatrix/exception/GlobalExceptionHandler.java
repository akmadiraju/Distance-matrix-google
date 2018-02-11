package com.ak.travel.travelmatrix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ak.travel.travelmatrix.model.ErrorResponse;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = InvalidRequestException.class)
	public ResponseEntity<Object> invalidException(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setId(400);
		errorResponse.setDevText("Please include Valid Origin or Destination in the Request");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(errorResponse);
	}
	
	@ExceptionHandler(value = UnknownServiceException.class)
	public ResponseEntity<Object> unknownException(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setId(400);
		errorResponse.setMessage(ex.getLocalizedMessage());
		errorResponse.setDevText("Please include Valid Origin or Destination in the Request");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(errorResponse);
		
	}

}
