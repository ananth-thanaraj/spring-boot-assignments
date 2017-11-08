package com.password.exception;

import org.springframework.http.HttpStatus;

public class HandleException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public void throwpasswordMatchException() throws Exception{
		CustomException ce = new CustomException();
		ce.setStatusCode(HttpStatus.NOT_IMPLEMENTED.value());
		ce.setMessage("Password did not meet the standards");
		throw ce;
	}
	
	public void userObjectNotException() throws Exception{
		CustomException ce = new CustomException();
		ce.setStatusCode(HttpStatus.NOT_FOUND.value());
		ce.setMessage("Please enter complete user credentials and submit");
		throw ce;
	}

}
