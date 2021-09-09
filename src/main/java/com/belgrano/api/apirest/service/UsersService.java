package com.belgrano.api.apirest.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belgrano.api.apirest.model.Users;
import com.belgrano.api.apirest.repository.*;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersrepository;
	
	//crear usuarios
	public Users save(String nickname, String password) {
		return usersrepository.save(new Users(nickname, password));
	}
	//listar usuarios	
	public List<Users> getAll(){
		return usersrepository.findAll();
	}
	//Obtener Usuarios por nombre usuario
	public Users getbyuser(String nickname) {
		return usersrepository.findByUser(nickname);
	}
	//Obtener Usuarios por id
//	public Users getbyid(String id) {
//		return usersrepository.findbyId(id);
//	}
	//Actualizar usuarios
	public Users updateUsers(String nickname, String password) {
		Users u = usersrepository.findByUser(nickname);
		u.setUser(nickname);
		u.setPassword(password);
		return usersrepository.save(u);
	}
	
	public void delete(String nickname ){
		Users u = usersrepository.findByUser(nickname);
		usersrepository.delete(u);
	}
}
