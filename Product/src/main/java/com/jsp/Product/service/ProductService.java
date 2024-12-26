package com.jsp.Product.service;

import java.util.List;

import com.jsp.Product.entity.Products;

public interface ProductService {
	
	public Products saveProducts(Products products);
	public Products findByProductid(int id);
	public List<Products> findByPriceRance(double range1,double range2);
	public void deleteById(int id);
}