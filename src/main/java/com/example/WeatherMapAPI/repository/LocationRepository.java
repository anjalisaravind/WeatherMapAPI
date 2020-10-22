package com.example.WeatherMapAPI.repository;


import com.example.WeatherMapAPI.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends MongoRepository<Location, String>{
	
	public Location findByLocationId(String locationId);
}
