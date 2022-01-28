package com.tourguide.attraction.service;

import java.util.List;
import java.util.UUID;

import com.tourguide.attraction.model.Attraction;
import com.tourguide.attraction.model.Reward;
import com.tourguide.attraction.model.VisitedLocation;

public interface AttractionService {
	
	List<Reward> getRewardsByUser(UUID user);
	
	Attraction getAttractionWithReward(UUID attractionId);
	
	List<Attraction> getNearByAttractions(VisitedLocation visitedLocation);

}
