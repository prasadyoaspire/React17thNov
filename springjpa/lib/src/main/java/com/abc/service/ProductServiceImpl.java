package com.abc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.dao.ProductDao;
import com.abc.entity.Product;


public class ProductServiceImpl implements ProductService  {
	
	private ProductDao productDao;	
	
	//setter injection
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Transactional
	@Override
	public void saveProduct(Product product) {
		
		productDao.createProduct(product);
		
	}

	@Override
	public Product getProductById(int productId) {
		
		Product product = productDao.findProduct(productId);
		
		return product;
	}



}
