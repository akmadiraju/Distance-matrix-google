package com.ak.travel.travelmatrix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travel-matrix")
public class ResourceController {
	
	
	@RequestMapping(value = "/health", 
			method=RequestMethod.GET,produces={"application/json","application/xml"})
	public ResponseEntity<Object> health(){
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
