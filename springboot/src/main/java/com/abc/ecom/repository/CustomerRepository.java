package com.abc.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.ecom.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	@Query("select c from Customer c where c.username = :uname and c.password = :pwd")
	Optional<Customer> login(@Param("uname") String username, @Param("pwd") String password);
}
