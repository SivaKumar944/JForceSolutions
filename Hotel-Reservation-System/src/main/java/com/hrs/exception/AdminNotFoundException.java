package com.hrs.exception;

public class AdminNotFoundException extends RuntimeException{

	public AdminNotFoundException(String message) {
		super(message);
	}

	public AdminNotFoundException() {
		super();
	}
	
	

}
