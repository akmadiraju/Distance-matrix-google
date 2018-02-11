package com.ak.travel.travelmatrix.exception;

public class UnknownServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5192031666415403304L;
	
	private String message;
	private int status;
	
	
	
	public UnknownServiceException() {
		super();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
