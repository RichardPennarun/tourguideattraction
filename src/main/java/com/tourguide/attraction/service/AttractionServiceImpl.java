package com.tourguide.attraction.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.attraction.model.Attraction;
import com.tourguide.attraction.model.Reward;
import com.tourguide.attraction.model.VisitedLocation;
import com.tourguide.attraction.repository.RewardRepository;

@Service
public class AttractionServiceImpl {

	@Autowired
	RewardRepository rewardRepository;

	@Autowired
	AttractionCentral attractionCentral;

	@Autowired
	RewardCentral rewardCentral;

	private static final double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;

	
	
	public List<Reward> getRewardsByUser(UUID userId) {
		List<Reward> userRewards = rewardRepository.findAllByUserId(userId);
		return userRewards;
	}

	
	
	public Attraction getAttractionWithReward(String attractionName) {
		List<Attraction> getAllAttractions = new ArrayList<>();
		Attraction attractionWithRewardPoints = new Attraction();
		
		// Recherche l'attraction
		getAllAttractions = (List<Attraction>) attractionCentral.getAttractions();
		for (Attraction attraction : getAllAttractions) {
			if (attraction.getAttractionName().equals(attractionName)) {
				
				// Récupérer le nombre de points attribués par RewardCentral
				int rewardPoints = rewardCentral.getAttractionRewardPoints(attraction.getId());
				attraction.setReward(rewardPoints);
				attractionWithRewardPoints = attraction;
			}
		}
		return attractionWithRewardPoints;
	}

	
	
	public List<Attraction> getNearByAttractions(VisitedLocation visitedLocation) {
		List<Attraction> nearbyAttractions = new ArrayList<>();
		List<Attraction> getAllAttractions = new ArrayList<>();
		
		// Récupération de toutes les attractions
		getAllAttractions = (List<Attraction>) attractionCentral.getAttractions();
		for (Attraction attraction : getAllAttractions) {
			
			// Calcul de leur distance à la dernière position de l'utilisateur
			attraction.setDistance(calculateDistance(attraction, visitedLocation));
		}
		
		// Classement des attractions par leur distance croissante à la dernière position de l'utilisateur
		Collections.sort(getAllAttractions, Attraction.ComparatorDistance);
		for (int i = 0; i < 5; i++) {
			
			// Récupération des 5 premières attractions
			nearbyAttractions.add(getAllAttractions.get(i));
		}
		
		// Ajout du reward pour les 5 attractions
		for (Attraction attraction : nearbyAttractions) {
			attraction.setReward(rewardCentral.getAttractionRewardPoints(attraction.getId()));
		}
		
		// TODO Classer les 5 attractions par distance
		
		return nearbyAttractions;
	}

	
	
	//Calcul de la distance entre une attraction et la position de l'utilisateur
	public double calculateDistance(Attraction attraction, VisitedLocation visitedLocation) {
		double lat1 = Math.toRadians(attraction.getLatitude());
		double lon1 = Math.toRadians(attraction.getLongitude());
		double lat2 = Math.toRadians(visitedLocation.getLatitude());
		double lon2 = Math.toRadians(visitedLocation.getLongitude());
		double angle = Math
				.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
		double nauticalMiles = 60 * Math.toDegrees(angle);
		double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
		return statuteMiles;
	}

}
