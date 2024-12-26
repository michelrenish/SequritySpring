package com.jsp.Product.exeption;

import lombok.Data;

@Data
public class ProductNotFoundExeption extends RuntimeException {
	
	private String Message="Product Not Found";
	
	public ProductNotFoundExeption() {
	}
	public ProductNotFoundExeption(String message) {
		super();
		Message = message;
	}
	
}
