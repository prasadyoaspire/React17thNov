package com.abc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.abc.entity.Product;


public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	public void createProduct(Product product) {	
		
		entityManager.persist(product);
	}

	@Override
	public Product findProduct(int productId) {		
		Product product = entityManager.find(Product.class, productId);
		return product;
	}

}
