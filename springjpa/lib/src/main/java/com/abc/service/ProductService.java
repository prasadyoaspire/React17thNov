package com.abc.service;

import com.abc.entity.Product;

public interface ProductService {

	public void saveProduct(Product product);
	
	public Product getProductById(int productId);
	
}
