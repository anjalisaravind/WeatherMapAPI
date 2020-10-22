package com.example.WeatherMapAPI.service;

import com.example.WeatherMapAPI.model.Location;
import com.example.WeatherMapAPI.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	private LocationRepository locationRepository;
	
	
	//Retrieve 
	
	public List<Location> findAll(){
	 return locationRepository.findAll();
		
	}
	public Location findByLocationId(String locationId) {
		 return locationRepository.findByLocationId(locationId);
	}
	
	//Save 
	
	public Location save(Location location) {
		return  locationRepository.save(location);
	}
	//Delete  All
	public String deleteAll() { 
		locationRepository.deleteAll(); 
		return "deleted All Locations";
		}
	
	
	//Delete by Id
	  public String deleteByLocationId(String locationId) { 
		 Location location =  locationRepository.findByLocationId(locationId); 
		 locationRepository.delete(location);
		 return "deleted Location " +location.getLocationName(); 
		 }
	 
	 

}
