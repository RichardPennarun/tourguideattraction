package com.tourguide.attraction;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.attraction.model.Attraction;
import com.tourguide.attraction.model.Reward;
import com.tourguide.attraction.model.VisitedLocation;
import com.tourguide.attraction.service.AttractionServiceImpl;


@RestController
public class AttractionController {
	
	@Autowired
	AttractionServiceImpl attractionServiceImpl;

	/*
	 * Read - Get 5 closest attractions to last GPS location saved
	 * @param An object VisitedLocationd
	 * @return A list of 5 objects Attraction
	 */
	@PostMapping("/getNearByAttractions")
	public List<Attraction> getNearByAttractions(@RequestBody VisitedLocation visitedLocation) {
		List<Attraction> nearByAttractions = attractionServiceImpl.getNearByAttractions(visitedLocation);
		return nearByAttractions;
	}

	/*
	 * Read - Get the number of reward points for a given attraction
	 * @param String The attraction name
	 * @return An object Attraction
	 */
	@GetMapping("getRewardPointsByAttraction/{attractionName}")
	public Attraction getRewardPointsByAttraction(@PathVariable("attractionName") final String attractionName) {
		Attraction attractionWithReward = attractionServiceImpl.getAttractionWithReward(attractionName);
		return attractionWithReward;
	}

	/*
	 * Read - Get the number of reward points earned by a given user
	 * @param Id The user id
	 * @return A list of objects Reward
	 */
	@GetMapping("getRewardsByUser/{userId}")
	public List<Reward> getRewardsByUser(@PathVariable("userId") final UUID userId) {
		List<Reward> userRewards = attractionServiceImpl.getRewardsByUser(userId);
		return userRewards;
	}
	
	
	
	
	
	
	
	
}
