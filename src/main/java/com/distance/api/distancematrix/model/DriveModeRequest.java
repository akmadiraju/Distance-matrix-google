package com.distance.api.distancematrix.model;

import java.io.Serializable;

public class DriveModeRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String drivingMode;

	public String getDrivingMode() {
		return drivingMode;
	}

	public void setDrivingMode(String drivingMode) {
		this.drivingMode = drivingMode;
	}

}
