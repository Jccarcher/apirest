package com.belgrano.api.rest.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.belgrano.api.apirest.controller.UsersController;
import com.belgrano.api.apirest.model.Users;
import com.belgrano.api.apirest.repository.UsersRepository;

public class UserControllerTest{
	
	@Autowired
	UsersRepository userRepositoryMock = mock(UsersRepository.class);

	@Autowired
	UsersController usersController = new UsersController(); 
	
	@Autowired
	Users mockuser;
	
	@BeforeEach
	void setUp(){
		mockuser = new Users(null, null); 
		mockuser.setUser("jcolina");
		mockuser.setPassword("jcolina1234");
		Mockito.when(userRepositoryMock.findByUser( "jcolina")).thenReturn(mockuser);
		
	}
	
	@Test
	void getUsersTest(){
		Assertions.assertTrue(mockuser.getUser().equals("jcolina"));
	}
	
	void getUsersTest2(){
		assertEquals("jcolina", mockuser.getUser());
	}
	
}
