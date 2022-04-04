package com.api.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.customer.model.ResponseApi;

@RestControllerAdvice
public class ValidationExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseApi handleException(RuntimeException e) {
		return new ResponseApi(e.getMessage(), HttpStatus.BAD_REQUEST.value());
	}

}
