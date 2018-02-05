package com.distance.api.distancematrix.controller.v1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.distance.api.distancematrix.model.DistanceElements;
import com.distance.api.distancematrix.service.DistanceService;

@RunWith(MockitoJUnitRunner.class)
public class DistanceResourceTest {

	private static String ORIGIN = "Austin";
	private static String DESTINATION = "SanAntonio";
	private static String ApiKey = "AIzaSyDu437HKDg6-w0SK0lB1aKIXoRFH0fZ_0A";

	@InjectMocks
	private DistanceResource distanceResource;
	
	@Mock
	private DistanceService mockDistanceService;
	@Mock
	private DistanceElements distanceElements;

	@Before
	public void setUp(){
		distanceElements.setDistance("12345");
		distanceElements.setDuration("1345");
	}
	
	@Test
	public void testSuccessDistance() {
		when(mockDistanceService.getDistanceMatrix(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(distanceElements);

		assertEquals(200, distanceResource.getDistance(ORIGIN, DESTINATION, ApiKey).getStatus());
		
	}
	


}
