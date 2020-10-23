package com.example.WeatherMapAPI.converter;

import com.example.WeatherMapAPI.dto.UserDto;
import com.example.WeatherMapAPI.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class userConverter {
	
	public UserDto entityToDto(User user) {
		
		UserDto dto = new UserDto();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		dto.setUserLocation(user.getUserLocation());
		dto.setUserLanguage(user.getUserLanguage());
		return dto;
		
	}
	
	public List<UserDto> entityToDto(List<User> user) {
		
		return user.stream().map(x->entityToDto(x)).collect(Collectors.toList());
		
	}
	
	public User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		user.setUserLocation(userDto.getUserLocation());
		user.setUserLanguage(userDto.getUserLanguage());
		return user;
	}
	
	
	public List<User> dtoToEntity(List<UserDto> userDto) {
		return userDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
				
	}

}
