package com.password.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ExceptionResponse> getPasswordNotChangedException(CustomException ex){
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorCode(ex.getStatusCode());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.OK);		
	}

}
