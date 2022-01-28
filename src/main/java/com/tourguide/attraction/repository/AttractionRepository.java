package com.tourguide.attraction.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourguide.attraction.model.Attraction;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, UUID> {

}
