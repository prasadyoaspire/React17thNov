package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.Address;
import com.abc.ecom.entity.Customer;
import com.abc.ecom.repository.CustomerRepository;

@SpringBootTest
public class CustomerServiceTest {
	
	@InjectMocks
	CustomerServiceImpl customerService = new CustomerServiceImpl();
	
	@Mock
	CustomerRepository customerRepository;
	
	@Test
	void testGetCustomerById() {
		
		Customer customer = new Customer();
		customer.setCustomerId(111);
		customer.setCustomerName("raj");
		customer.setEmail("raj@tmail.com");
		customer.setMobile("9638527410");
		customer.setUsername("raj");
		customer.setPassword("raj@123");
		
		Address address1 = new Address();
		address1.setAddressId(10);
		address1.setDoorNo("11/21");
		address1.setLocality("MG Road");
		address1.setCity("Chennai");
		address1.setPincode("123456");
		
		customer.setAddress(address1);		
		
		when(customerRepository.findById(111)).thenReturn(Optional.of(customer));
		
		Customer customerObj = customerService.getCustomerById(111);
		
		assertEquals("raj",customerObj.getCustomerName());
		
		assertEquals("Chennai",customerObj.getAddress().getCity());
		
	}


}
