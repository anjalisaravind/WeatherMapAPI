package com.example.WeatherMapAPI.Controller;

import com.example.WeatherMapAPI.converter.userConverter;
import com.example.WeatherMapAPI.dto.UserDto;
import com.example.WeatherMapAPI.model.User;
import com.example.WeatherMapAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private userConverter userConverter;
	
	
	@GetMapping("/findAll")
	public List<UserDto> findAll(){
		List<User> userList = userService.findAll();
		return userConverter.entityToDto(userList);
		
		
	}



	  @GetMapping("/find/{id}")
	  public UserDto findByUserId(@PathVariable (value ="id") String userId) {
		  
		  User user =    userService.findByUserId(userId);
		  return userConverter.entityToDto(user);
	  
	  }
	
	@PostMapping("/save")
		public UserDto save(@RequestBody UserDto userDto) {
		User user = userConverter.dtoToEntity(userDto);		
		 user= userService.save(user);		 
		 return userConverter.entityToDto(user);
	}

	 

	 
	 @PostMapping( "update/{id}")
		public UserDto updateUserById(@PathVariable("id") String userId,  @RequestBody UserDto userDto) {	
		 User user =    userService.findByUserId(userId);
		 User user1 = userConverter.dtoToEntity(userDto);
		 user.setUserLocation(user1.getUserLocation());
		user =userService.save(user);
		return userConverter.entityToDto(user);
			
		}
	 @GetMapping("/deleteAll") 
		 public String deleteAll() {
		 return userService.deleteAll();
		 
		 
		 }
	
	 
	 @GetMapping("/delete/{id}")
	 	public String deleteUserById(@PathVariable("id") String userId) { 
		return  userService.deleteByUserId(userId); 

		 }


	@GetMapping("/findUsersByLanguage")
	public List<UserDto> findAllENUsers() {
		List<User>  userList = userService.findAllENUsers();
		return userConverter.entityToDto(userList);

	}

}
