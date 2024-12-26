package com.jsp.singupLogin.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandler {
	@ExceptionHandler(InvalidCridantial.class)
	public ResponseEntity InvalidCridantial(InvalidCridantial ex) {
		return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidOTP.class)
	public ResponseEntity InvalidOTP(InvalidOTP ex) {
		return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}

