package com.password.exception;

public class CustomException extends  Exception{


	private static final long serialVersionUID = 1L;
	
	private int statusCode;
	private String message;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
