package com.collage.system.common.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collage.system.common.entity.City;

public interface CityRepo extends JpaRepository<City,Integer> {

	
}
