package com.satmed.region.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.region.models.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{
    
}
