package com.jsp.Product.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.Product.dao.ProductDao;
import com.jsp.Product.entity.Products;
import com.jsp.Product.exeption.ProductNotFoundExeption;
import com.jsp.Product.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	ProductDao productDao;

	@Override
	public Products saveProducts(Products products) {
		return productDao.saveProducts(products);
	}

	@Override
	public Products findByProductid(int id) {
		return productDao.findByProductid(id).orElseThrow(() -> new ProductNotFoundExeption("ProductNotFoundExeption"));
	}

	@Override
	public List<Products> findByPriceRance(double range1, double range2) {
		List<Products> list=productDao.findByPriceRance(range1, range2);
		if(list != null) {
			return list;
		}else {
			throw new ProductNotFoundExeption("Product not found between the range of "+range1+" and "+range2);
		}
	}

	@Override
	public void deleteById(int id) {
	Products pro =findByProductid(id);
		if(pro != null) {
			productDao.deleteById(id);
		}
	}

}
