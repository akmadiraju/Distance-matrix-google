package com.ak.travel.travelmatrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ak.travel.travelmatrix.service.TravelMatrixServiceImpl;

@RestController
@RequestMapping("/travel-matrix")
public class ResourceController {
	
	@Autowired
	private TravelMatrixServiceImpl travelServiceImpl;
	
	
	@RequestMapping(value = "/health", 
			method=RequestMethod.GET,produces={"application/json","application/xml"})
	public ResponseEntity<Object> health(){
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	
	@RequestMapping(value = "/origin/{originLocation}/destination/{destinationLocation}",
			method=RequestMethod.GET, 
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> getDistanceMatrix(@PathVariable String originLocation,
			@PathVariable String destinationLocation){
		return ResponseEntity.status(HttpStatus.OK)
				.body(travelServiceImpl.getTravelDetails(originLocation, destinationLocation));
		
	}

}
