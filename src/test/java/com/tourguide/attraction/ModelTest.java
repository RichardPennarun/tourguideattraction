package com.tourguide.attraction;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tourguide.attraction.model.Attraction;
import com.tourguide.attraction.model.Reward;
import com.tourguide.attraction.model.VisitedLocation;


@SpringBootTest
public class ModelTest {


	@Test
	public void getRewardTest() {
		Reward r = new Reward();
		final UUID uuid = UUID.randomUUID();
		final UUID uuid2 = UUID.randomUUID();
		final int rewardPoints = 15;
		final Date timeVisited = new Date();
		r.setUserId(uuid);
		r.setAttractionId(uuid2);
		r.setRewardPoints(rewardPoints);
		r.setTimeVisited(timeVisited);
		assertThat(r.getUserId()).isEqualTo(uuid);
		assertThat(r.getAttractionId()).isEqualTo(uuid2);
		assertThat(r.getRewardPoints()).isEqualTo(rewardPoints);
		assertThat(r.getTimeVisited()).isEqualTo(timeVisited);
	}
	
	@Test
	public void setRewardTest() {
		final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final UUID uuid2 = UUID.randomUUID();
		final int rewardPoints = 15;
		final Date timeVisited = new Date();
		Reward reward = new Reward(id, uuid, uuid2, rewardPoints, timeVisited);
		assertThat(reward.getId()).isEqualTo(id);
		assertThat(reward.getUserId()).isEqualTo(uuid);
		assertThat(reward.getAttractionId()).isEqualTo(uuid2);
		assertThat(reward.getRewardPoints()).isEqualTo(rewardPoints);
		assertThat(reward.getTimeVisited()).isEqualTo(timeVisited);
	}


	@Test
	public void getAttractionTest() {
		Attraction a = new Attraction();
		final UUID id = UUID.randomUUID();
		
		a.setId(id);
		a.setAttractionName("Disneyland");
		a.setCity("Orlando");
		a.setState("Florida");
		a.setLatitude(-125.808708);
		a.setLongitude(5.64892);
		a.setDistance(550);
		a.setReward(15);
		assertThat(a.getId()).isEqualTo(id);
		assertThat(a.getAttractionName()).isEqualTo("Disneyland");
		assertThat(a.getCity()).isEqualTo("Orlando");
		assertThat(a.getState()).isEqualTo("Florida");
		assertThat(a.getLatitude()).isEqualTo(-125.808708);
		assertThat(a.getLongitude()).isEqualTo(5.64892);
		assertThat(a.getDistance()).isEqualTo(550);
		assertThat(a.getReward()).isEqualTo(15);
	}
	
	@Test
	public void setAttractionTest() {
		final UUID id = UUID.randomUUID();
		Attraction attraction = new Attraction(id, "Disneyland", "Orlando", "Florida", -125.808708, 5.64892, 550, 15);
		assertThat(attraction.getId()).isEqualTo(id);
		assertThat(attraction.getAttractionName()).isEqualTo("Disneyland");
		assertThat(attraction.getCity()).isEqualTo("Orlando");
		assertThat(attraction.getState()).isEqualTo("Florida");
		assertThat(attraction.getLatitude()).isEqualTo(-125.808708);
		assertThat(attraction.getLongitude()).isEqualTo(5.64892);
		assertThat(attraction.getDistance()).isEqualTo(550);
		assertThat(attraction.getReward()).isEqualTo(15);
	}


	@Test
	public void getVisitedLocationTest() {
		VisitedLocation vl = new VisitedLocation();
		final UUID uuid = UUID.randomUUID();
		final Date timeVisited = new Date();
		vl.setUserId(uuid);
		vl.setLatitude(-125.808708);
		vl.setLongitude(5.64892);
		vl.setTimeVisited(timeVisited);
		assertThat(vl.getUserId()).isEqualTo(uuid);
		assertThat(vl.getLatitude()).isEqualTo(-125.808708);
		assertThat(vl.getLongitude()).isEqualTo(5.64892);
		assertThat(vl.getTimeVisited()).isEqualTo(timeVisited);
	}
	
	@Test
	public void setVisitedLocationTest() {
		final UUID id = UUID.randomUUID();
		final UUID uuid = UUID.randomUUID();
		final Date timeVisited = new Date();
		VisitedLocation visitedLocation = new VisitedLocation(id, uuid, -125.808708, 5.64892, timeVisited);
		assertThat(visitedLocation.getId()).isEqualTo(id);
		assertThat(visitedLocation.getUserId()).isEqualTo(uuid);
		assertThat(visitedLocation.getLatitude()).isEqualTo(-125.808708);
		assertThat(visitedLocation.getLongitude()).isEqualTo(5.64892);
		assertThat(visitedLocation.getTimeVisited()).isEqualTo(timeVisited);
	}
}
