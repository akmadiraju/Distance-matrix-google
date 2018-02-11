package com.ak.travel.travelmatrix.model;

import java.io.Serializable;

public class ErrorResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3895422537715399336L;
	
	private int id;
	private String message;
	private String devText;
	
	public ErrorResponse(int id, String message, String devText) {
		super();
		this.id = id;
		this.message = message;
		this.devText = devText;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDevText() {
		return devText;
	}

	public void setDevText(String devText) {
		this.devText = devText;
	}

	
	
	
}
