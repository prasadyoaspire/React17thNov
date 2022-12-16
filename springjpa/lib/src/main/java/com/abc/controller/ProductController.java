package com.abc.controller;

import org.springframework.stereotype.Controller;

import com.abc.entity.Product;
import com.abc.service.ProductService;


public class ProductController {

	private ProductService productService;
	
	//setter injection
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void addProduct(Product product) {
		
		productService.saveProduct(product);
		
		System.out.println("Product saved");
	}
	
	public void getProductDetails(int productId) {
		
		Product product = productService.getProductById(productId);
		
		if(product!=null) {
			
			System.out.println("Product Name: "+product.getProductName());
			System.out.println("Product Price: "+product.getProductPrice());
			System.out.println("Product Created: "+product.getCreatedOn());
		}
		else {
			System.out.println("Product not existing");
		}
	}
}
