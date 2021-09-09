package com.belgrano.api.apirest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
	@Id
	public String id;
	public String nickname;
	public String password;
	
	public Users(String nickname, String password) {
		super();
		this.nickname = nickname;
		this.password = password;
	}

	public String getUser() {
		return nickname;
	}

	public void setUser(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
