package com.jsp.Product.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeption {
	@ExceptionHandler(ProductNotFoundExeption.class)
	public ResponseEntity ProductNotFoundExeption(ProductNotFoundExeption ex){
		return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
