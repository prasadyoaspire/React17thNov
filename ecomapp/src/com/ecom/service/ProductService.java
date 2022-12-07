package com.ecom.service;

import com.ecom.dao.ProductDao;
import com.ecom.dto.Product;
import com.ecom.exception.ProductNotFoundException;

public class ProductService {

	public float buyProduct(int productId, int quantity) throws ProductNotFoundException {		
		
		//get the product price from the database
		ProductDao productDao = new ProductDao();
		Product product = productDao.getProductDetails(productId);
		if(product==null) {
			throw new ProductNotFoundException("Product not found with id: "+productId);
		}
		
		float productPrice = product.getProductPrice();
		
		//calculate total price (price*quantity)
		float totalPrice = productPrice * quantity;
		
		//add gst 8%
		float finalAmount = totalPrice+totalPrice * 0.08f;
		
		//return final amount		
		return finalAmount;
		
	}
	
	public void saveProduct(Product product) {
		ProductDao productDao = new ProductDao();
		
		productDao.addProduct(product);
	}
}
