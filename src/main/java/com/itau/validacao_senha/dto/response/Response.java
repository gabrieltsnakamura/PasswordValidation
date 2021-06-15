package com.itau.validacao_senha.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response<T> {

	private T data;
	private List<ResponseError> errors = new ArrayList<>();

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Object getErrors() {
		return errors;
	}

	public void setErrors(List<ResponseError> errors) {
		this.errors = errors;
	}

	public void addErrorMessage(String errMsg) {
		ResponseError error = new ResponseError();
		error.setMessage(errMsg);
		errors.add(error);
	}

}
