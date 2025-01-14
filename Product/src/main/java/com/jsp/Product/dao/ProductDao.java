package com.jsp.Product.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Product.entity.Products;
import com.jsp.Product.repository.ProductRepo;

@Repository
public class ProductDao {
	@Autowired
	ProductRepo productRepo;
	
	public Products saveProducts(Products products) {
		return productRepo.save(products);
	}
	public Optional<Products> findByProductid(int id) {
		return productRepo.findById(id);
	}
	public List<Products> findByPriceRance(double range1,double range2){
		return productRepo.findByPriceRance(range1, range2);
	}
	public void deleteById(int id) {
//		Optional<Products> pro =findByProductid(id);
//		if(pro != null)
			productRepo.deleteById(id);
	}
	
}
