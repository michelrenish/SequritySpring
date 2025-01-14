package com.jsp.Product.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jsp.Product.entity.Products;
import com.jsp.Product.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/saveproduct")
	public ResponseEntity<Products> saveProduct(@RequestBody Products products){
		return new ResponseEntity<Products>(productService.saveProducts(products),HttpStatus.ACCEPTED);
	}
	@GetMapping("/findByProductid")
	public ResponseEntity<Products> findByProductid(@RequestParam int id) {
		return new ResponseEntity<Products>(productService.findByProductid(id),HttpStatus.FOUND);
	}
	@GetMapping("findByPriceRance")
	public ResponseEntity<List<Products>> findByPriceRance(@RequestParam double range1,@RequestParam double range2) {
		return new ResponseEntity<List<Products>>(productService.findByPriceRance(range1, range2),HttpStatus.FOUND);
	}
	@DeleteMapping("deleteById")
	public ResponseEntity findByPriceRance(@RequestParam int id){
		productService.deleteById(id);
		return new ResponseEntity("Product Detail was deleted",HttpStatus.OK);
	}
}
