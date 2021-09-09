package com.belgrano.api.apirest.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.belgrano.api.apirest.model.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String>{
	
	public Users findByUser(String nickname);
}
