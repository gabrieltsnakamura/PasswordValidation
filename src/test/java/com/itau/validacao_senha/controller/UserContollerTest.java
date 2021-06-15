package com.itau.validacao_senha.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.validacao_senha.service.user.UserService;

@WebMvcTest(UserController.class)
public class UserContollerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	UserService userService;
	
	@Test
	public void validJson() throws Exception {
		
		Mockito.when(userService.validateUser("aa")).thenReturn(false);
		
		JSONObject input = new JSONObject();
		input.put("password", "aa");
		mockMvc.perform(MockMvcRequestBuilders
				.post("/api/v1/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(input.toString()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data").value("false"));
	}
	
	@Test
	public void invalidJson() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/api/v1/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("aa"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors[0].message").value("Invalid JSON provided."));
	}
	
	@Test
	public void invalidBodyParameter() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/api/v1/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{}"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors[0].message").value("Password cannot be empty."));
	}
	
}
