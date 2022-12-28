package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {
	
	@InjectMocks
	private ProductServiceImpl productService = new ProductServiceImpl();
	
	@Mock
	private ProductRepository productRepository;

	@Test
	void testGetProductById() {
		
		Product product = new Product();
		product.setProductId(1234);
		product.setProductName("IPhoneX");
		product.setProductPrice(56000);
		product.setCreatedOn(LocalDate.of(2020, 10, 10));
		product.setCategory("mobile");
		
		Optional<Product> optionalProduct = Optional.of(product);
		
		when(productRepository.findById(1234)).thenReturn(optionalProduct);
		
		Product productObj = productService.getProductById(1234);
		
		assertEquals("IPhoneX",productObj.getProductName());
		assertEquals(56000,productObj.getProductPrice());				
	}
	
	@Test
	public void testGetProductByIdException() {
		
		when(productRepository.findById(1020)).thenThrow(ProductNotFoundException.class);
		
		assertThrows(ProductNotFoundException.class,()->productService.getProductById(1020));
	}
	
	@Test
	void testGetAllProducts() {
		
		List<Product> products = new ArrayList<>();
		
		Product product1 = new Product();
		product1.setProductId(1111);
		product1.setProductName("IPhoneX");
		product1.setProductPrice(66000);
		product1.setCreatedOn(LocalDate.of(2020, 10, 10));
		product1.setCategory("mobile");
		
		Product product2 = new Product();
		product2.setProductId(2222);
		product2.setProductName("IPhoneY");
		product2.setProductPrice(56000);
		product2.setCreatedOn(LocalDate.of(2020, 10, 10));
		product2.setCategory("mobile");
		
		Product product3 = new Product();
		product3.setProductId(3333);
		product3.setProductName("IPhoneZ");
		product3.setProductPrice(36000);
		product3.setCreatedOn(LocalDate.of(2020, 10, 10));
		product3.setCategory("mobile");
		
		products.add(product3);
		products.add(product2);
		products.add(product1);
		
		when(productRepository.findAll()).thenReturn(products);
		
		List<Product> productList = productService.getAllProducts();
		
		assertEquals(3,productList.size());				
	}
	
	@Test
	public void testDeleteProduct() {
		
		Product product = new Product();
		product.setProductId(1234);
		product.setProductName("IPhoneX");
		product.setProductPrice(56000);
		product.setCreatedOn(LocalDate.of(2020, 10, 10));
		product.setCategory("mobile");
		
		Optional<Product> optionalProduct = Optional.of(product);
		
		when(productRepository.findById(1234)).thenReturn(optionalProduct);
		
		doNothing().when(productRepository).deleteById(1234);
		
		productService.deleteProduct(1234);
		
		verify(productRepository,times(1)).findById(1234);
		verify(productRepository,times(1)).deleteById(1234);
	}
	
	@Test
    void testSaveProduct() {
		Product product = new Product();
		product.setProductId(1234);
		product.setProductName("IPhoneX");
		product.setProductPrice(56000);
		product.setCreatedOn(LocalDate.of(2020, 10, 10));
		product.setCategory("mobile");
		
		when(productRepository.save(product)).thenReturn(product);
		
		Product newProduct = productService.saveProduct(product);
		
		assertEquals("IPhoneX",newProduct.getProductName());
		
    }
}
