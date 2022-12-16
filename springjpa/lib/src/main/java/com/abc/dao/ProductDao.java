package com.abc.dao;

import com.abc.entity.Product;

public interface ProductDao {

	public void createProduct(Product product);
	
	public Product findProduct(int productId);
	
}
