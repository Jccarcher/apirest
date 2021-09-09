package com.belgrano.api.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.belgrano.api.apirest.model.Users;
import com.belgrano.api.apirest.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService userservice;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestParam String nickname, @RequestParam String password) {
		Users u = userservice.save(nickname, password);
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/getUser")
	public Users getUser(@RequestParam String nickname){
		return userservice.getbyuser(nickname);
	}
	
	@GetMapping("/getAllUser")
	public List<Users> getAll(){
		return userservice.getAll();
	}
	
//	@RequestMapping("/getUserById")
//	public Users getUserbyid(@RequestParam String id){
//		return userservice.getbyid(id);
//	}
	
	@RequestMapping("/updateUser")
		public String update(@RequestParam String nickname, @RequestParam String password){
		Users u = userservice.updateUsers(nickname, password);
		return u.toString(); 
	}
	
	@RequestMapping("/deleteUser")
	public String delete(String nickname) {
		userservice.delete(nickname);
		return "eliminado:" + nickname;
	}
}
