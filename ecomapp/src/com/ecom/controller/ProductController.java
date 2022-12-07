package com.ecom.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.ecom.dto.Product;
import com.ecom.exception.ProductNotFoundException;
import com.ecom.service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		
		ProductController productController = new ProductController();
		
		//buy product
		
//		Scanner sc =new Scanner(System.in);
//		System.out.println("Enter productid");
//		int productId = sc.nextInt();
//		System.out.println("Enter quantity");
//		int quantity= sc.nextInt();
//		sc.close();
//		
//		productController.placeOrder(productId,quantity);
		
		//save product
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter productid");
		int pId = sc.nextInt();
		System.out.println("Enter product name");
		String pName = sc.next();
		System.out.println("Enter product Price");
		float pPrice = sc.nextFloat();		
		System.out.println("Enter product created date(yyyy-MM-dd)");
		String sDate = sc.next();		
		sc.close();
		//convert string date to LocalDate		
		LocalDate pDate = LocalDate.parse(sDate);
		
		Product product = new Product();
		product.setProductId(pId);
		product.setProductName(pName);
		product.setProductPrice(pPrice);
		product.setCreatedOn(pDate);
		
		productController.createProduct(product);
		
	}
	
	public void placeOrder(int productId, int quantity) {
		
		ProductService productService = new ProductService();
		try {
			float totalAmount = productService.buyProduct(productId, quantity);
			System.out.println("Total Amount (includes 8% gsg) = "+totalAmount);
		}
		catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void createProduct(Product product) {
		ProductService productService = new ProductService();
		productService.saveProduct(product);
		System.out.println("Product saved");
	}
}
