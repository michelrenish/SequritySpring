package com.jsp.Product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.Product.entity.Products;

public interface ProductRepo extends JpaRepository<Products,Integer> {
	
	@Query(nativeQuery = true, value="select * from Products where price between ?1 and ?2")
	public List<Products> findByPriceRance(double range1,double range2);
}
