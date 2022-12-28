package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.entity.Product;
import com.abc.ecom.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/all")
	public List<Customer> fetchAllCustomers() {
		List<Customer> list = customerService.getAllCustomers();
		return list;
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> fetchCustomerDetails(@PathVariable("id") int customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/customer/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.saveCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/customer/login/{uname}/{pwd}")
	public ResponseEntity<Customer> customerLogin(@PathVariable("uname") String username, @PathVariable("pwd") String password) {
		
		ResponseEntity<Customer> responseEntity = null;
		Customer customer = customerService.doLogin(username, password);		
		responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
		
		return responseEntity;
	}
}
