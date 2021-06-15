package com.itau.validacao_senha.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.validacao_senha.dto.model.user.UserDTO;
import com.itau.validacao_senha.dto.response.Response;
import com.itau.validacao_senha.service.user.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public ResponseEntity<Response<Boolean>> validatePassword(@Valid @RequestBody UserDTO userDTO, BindingResult result) throws JsonProcessingException {
        
		Response<Boolean> response = new Response<>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMessage(error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		response.setData(userService.validateUser(userDTO.convertDTOToEntity().getPassword()));
		logger.info("Request:" + mapper.writeValueAsString(userDTO) + "Response:" + mapper.writeValueAsString(response));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
