package com.itau.validacao_senha.model.user;

import org.modelmapper.ModelMapper;

import com.itau.validacao_senha.dto.model.user.UserDTO;

public class User {
	
	private String user;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserDTO convertEntityToDTO() {
		return new ModelMapper().map(this, UserDTO.class);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
