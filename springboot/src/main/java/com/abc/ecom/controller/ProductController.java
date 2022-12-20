package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Product;
import com.abc.ecom.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product/all")
	public List<Product> fetchAllProducts() {
		List<Product> list = productService.getAllProducts();
		return list;
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> fetchProductDetails(@PathVariable("id") int productId) {
		Product product = productService.getProductById(productId);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/product/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newProduct = productService.saveProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct, HttpStatus.CREATED);
		return responseEntity;
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> removeProduct(@PathVariable("id") int productId) {
		productService.deleteProduct(productId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Product Deleted Successfully.", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/product/update")
	public ResponseEntity<Product> modifyProduct(@RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(updatedProduct, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/product/byname/{name}")
	public ResponseEntity<Product> fetchProductByName(@PathVariable("name") String productName) {
		Product product = productService.getProductByName(productName);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/product/bycategory/{category}")
	public List<Product> fetchProductByCategory(@PathVariable("category") String category) {
		List<Product> products = productService.getProductsByCategory(category);	
		return products;
	}
	
}
