package com.example.WeatherMapAPI.converter;

import com.example.WeatherMapAPI.dto.LocationDto;
import com.example.WeatherMapAPI.model.Location;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class locationConverter {
	
	public LocationDto entityToDto(Location location) {
		
		LocationDto dto = new LocationDto();
		dto.setLocationId(location.getLocationId());
		dto.setLocationName(location.getLocationName());
		return dto;
		
	}
	
	public List<LocationDto> entityToDto(List<Location> location) {
		
		return location.stream().map(x->entityToDto(x)).collect(Collectors.toList());
		
	}
	
	public Location dtoToEntity(LocationDto locationDto) {
		Location location = new Location();
		location.setLocationId(locationDto.getLocationId());
		location.setLocationName(locationDto.getLocationName());
		return location;
	}
	
	
	public List<Location> dtoToEntity(List<LocationDto> locationDto) {
		return locationDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
				
	}

}
