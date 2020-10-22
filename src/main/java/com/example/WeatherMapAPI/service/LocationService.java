package com.example.WeatherMapAPI.service;

import com.example.WeatherMapAPI.model.Location;

import java.util.List;

public interface LocationService {
	
	public Location save(Location location);
	public List<Location> findAll();
	public Location findByLocationId(String locationId);
	public String deleteAll();
	public String deleteByLocationId(String locationId) ;
	
	
}
