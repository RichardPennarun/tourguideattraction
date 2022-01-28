package com.tourguide.attraction.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourguide.attraction.model.Reward;


public interface RewardRepository extends JpaRepository<Reward, Integer> {
	
	List<Reward> findAllByUserId(UUID userId);

}
