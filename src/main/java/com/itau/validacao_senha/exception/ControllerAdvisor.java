package com.itau.validacao_senha.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itau.validacao_senha.controller.UserController;
import com.itau.validacao_senha.dto.response.Response;

@ControllerAdvice
public class ControllerAdvisor {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	Response<Object> response;
	
	@ExceptionHandler({HttpMessageNotReadableException.class, JsonProcessingException.class})
	public ResponseEntity<Response<Object>> handleJsonParseException(HttpMessageNotReadableException ex, WebRequest request) {
		response = new Response<>();
		response.addErrorMessage("Invalid JSON provided.");
		logger.error("Invalid JSON provided - Exception - ", ex);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response<Object>> UnknownErrorException(HttpMessageNotReadableException ex, WebRequest request) {
		response = new Response<>();
		response.addErrorMessage("An unexpected error occured.");
		logger.error("An unexpected error occured - Exception - ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
