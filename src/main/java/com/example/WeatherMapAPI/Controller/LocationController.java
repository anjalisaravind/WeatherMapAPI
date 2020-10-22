package com.example.WeatherMapAPI.Controller;

import com.example.WeatherMapAPI.converter.locationConverter;
import com.example.WeatherMapAPI.dto.LocationDto;
import com.example.WeatherMapAPI.model.Location;
import com.example.WeatherMapAPI.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private locationConverter locationConverter;


	@GetMapping("/findAllLocation")
	public List<LocationDto> findAll() {
		List<Location> locationList = locationService.findAll();
		return locationConverter.entityToDto(locationList);
	}


    @GetMapping("/findLocation/{id}")
    public LocationDto findByLocationId(@PathVariable(value = "id") String locationId) {
        Location location = locationService.findByLocationId(locationId);
        return locationConverter.entityToDto(location);

    }

    @PostMapping("/saveLocation")
    public LocationDto save(@RequestBody LocationDto locationDto) {
        Location location = locationConverter.dtoToEntity(locationDto);
        location = locationService.save(location);
        return locationConverter.entityToDto(location);
    }


    @PostMapping("updateLocation/{id}")
    public LocationDto updateLocationById(@PathVariable("id") String locationId, @RequestBody LocationDto locationDto) {
        Location location = locationService.findByLocationId(locationId);
        Location location1 = locationConverter.dtoToEntity(locationDto);
        location.setLocationName(location1.getLocationName());
        location = locationService.save(location);
        return locationConverter.entityToDto(location);

    }

    @GetMapping("/deleteAllLocation")
    public String deleteAll() {
        return locationService.deleteAll();


    }


    @GetMapping("/deleteLocation/{id}")
    public String deleteLocationById(@PathVariable("id") String locationId) {
        return locationService.deleteByLocationId(locationId);

    }


}
