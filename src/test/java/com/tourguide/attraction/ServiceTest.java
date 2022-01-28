package com.tourguide.attraction;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.attraction.model.Attraction;
import com.tourguide.attraction.model.VisitedLocation;
import com.tourguide.attraction.service.AttractionServiceImpl;


@SpringBootTest
public class ServiceTest {
	
	@Autowired
	AttractionServiceImpl attractionServiceImpl;
	
	@Test
	public void getNearByAttractionsTest() {
		
		VisitedLocation vl = new VisitedLocation();
		final UUID uuid = UUID.randomUUID();
		final Date timeVisited = new Date();
		vl.setUserId(uuid);
		vl.setLatitude(-125.808708);
		vl.setLongitude(5.64892);
		vl.setTimeVisited(timeVisited);
		
		List<Attraction> nearByAttractions = attractionServiceImpl.getNearByAttractions(vl);
		
		for (Attraction attraction : nearByAttractions) {
			assertThat(attraction.getReward()).isNotNull();
		}
	}
}
