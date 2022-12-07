package com.ecom.controller;

import java.util.Scanner;

import com.ecom.service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter productid");
		int productId = sc.nextInt();
		System.out.println("Enter quantity");
		int quantity= sc.nextInt();
		sc.close();
		
		ProductController productController = new ProductController();
		
		productController.placeOrder(productId,quantity);
		
	}
	
	public void placeOrder(int productId, int quantity) {
		
		ProductService productService = new ProductService();
		float totalAmount = productService.buyProduct(1001, 3);
		System.out.println("Total Amount (includes 8% gsg) = "+totalAmount);
	}
}
