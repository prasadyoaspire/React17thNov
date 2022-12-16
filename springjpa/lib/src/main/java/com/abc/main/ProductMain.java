package com.abc.main;

import java.time.LocalDate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.controller.ProductController;
import com.abc.entity.Product;

public class ProductMain {

	public static void main(String[] args) {
		
		Product product1 = new Product();
		product1.setProductId(1116);
		product1.setProductName("NewPhone6");
		product1.setProductPrice(96000);
		product1.setCreatedOn(LocalDate.of(2022, 12, 16));
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
		
		ProductController productController = (ProductController) context.getBean("pController");
		
		productController.addProduct(product1);
		
		context.close();

	}

}
