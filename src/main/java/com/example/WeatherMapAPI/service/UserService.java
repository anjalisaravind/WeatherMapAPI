package com.example.WeatherMapAPI.service;

import com.example.WeatherMapAPI.model.User;

import java.util.List;


public interface UserService {
	
	public User save(User user);
	public List<User> findAll();
	public User findByUserId(String userId);
	public String deleteAll();
	public String deleteByUserId(String userId) ;
	public List<User> findAllENUsers();

}
