package com.distance.api.distancematrix.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorMessage  {
	
	private String message;
	private int id;

	public ErrorMessage() {
		
	}


	public ErrorMessage( int id,String message) {
		super();
		this.id = id;
		this.message = message;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


}
