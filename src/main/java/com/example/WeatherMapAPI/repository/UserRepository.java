package com.example.WeatherMapAPI.repository;

import com.example.WeatherMapAPI.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	public User findByUserId(String userId);


}
