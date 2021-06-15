package com.itau.validacao_senha.dto.model.user;

import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.itau.validacao_senha.model.user.User;

public class UserDTO extends RepresentationModel<UserDTO>{

	private String user;
	
	@NotBlank(message = "Password cannot be empty.")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User convertDTOToEntity() {
		return new ModelMapper().map(this, User.class);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
