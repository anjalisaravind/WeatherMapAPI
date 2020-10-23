package com.example.WeatherMapAPI.dto;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserDto {
	
	private String userId;
	private String userName;
	private String userLocation;
	private List<String> userLanguage;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public List<String> getUserLanguage() {
		return userLanguage;
	}

	public void setUserLanguage(List<String> userLanguage) {
		this.userLanguage = userLanguage;
	}

	

}
