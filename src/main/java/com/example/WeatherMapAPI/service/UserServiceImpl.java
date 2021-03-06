package com.example.WeatherMapAPI.service;

import com.example.WeatherMapAPI.model.User;
import com.example.WeatherMapAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	
	//Retrieve 
	
	public List<User> findAll(){
	 return userRepository.findAll();
		
	}

	public User findByUserId(String userId) {
		 return userRepository.findByUserId(userId);
	}
	
	//Save 
	
	public User save(User user) {
		return  userRepository.save(user);
	}
	//Delete  All
	public String deleteAll() { 
		userRepository.deleteAll(); 
		return "deleted All Users";
		}
	
	
	//Delete by Id
	  public String deleteByUserId(String userId) { 
		 User user =  userRepository.findByUserId(userId); 
		 userRepository.delete(user);
		 return "deleted User " +user.getUserName(); 
		 }

//Get users by language
public List<User> findAllENUsers() {
	List<User> userList =  userRepository.findAll();
	return userList.stream().filter(user-> user.getUserLanguage().contains("EN")).collect(Collectors.toList());

}



}
