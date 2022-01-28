package com.tourguide.attraction.service;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class RewardCentral {
	
	public int getAttractionRewardPoints(UUID attractionId) {
        try {
            TimeUnit.MILLISECONDS.sleep((long)ThreadLocalRandom.current().nextInt(1, 1000));
        } catch (InterruptedException var4) {
        }

        int randomInt = ThreadLocalRandom.current().nextInt(1, 1000);
        return randomInt;
    }

}
