package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.service.CalculatorService;

public class CalculatorServiceTest {
	
	CalculatorService cal;
	
	@BeforeAll
	static void setUp() {
		System.out.println("before all");
	}
	
	@AfterAll
	static void tearDown() {
		System.out.println("after all");
	}
		
	@BeforeEach
	void beforeTest() {
		System.out.println("before each");
		cal = new CalculatorService();
	}
	
	@AfterEach
	void afterTest() {
		System.out.println("after each");
		cal = null;
	}
	
	@Disabled
	@Test
	public void testSum() {		
		System.out.println("testSum() called");
		//CalculatorService cal = new CalculatorService();
		int actualResult = cal.sum(10, 20);		
		assertEquals(30,actualResult);
	}
	
	@Test
	public void testSumWithNegativeValues() {	
		System.out.println("testSumWithNegativeValues() called");
		//CalculatorService cal = new CalculatorService();
		int actualResult = cal.sum(-10, -20);		
		assertEquals(-30,actualResult);
	}
	
	@Test
	public void testSumWithNegativePositiveValues() {	
		System.out.println("testSumWithNegativePositiveValues() called");
		//CalculatorService cal = new CalculatorService();
		int actualResult = cal.sum(10, -20);		
		assertEquals(-10,actualResult);
	}
	
	@Test
	public void testDiv() {
		int actualResult = cal.div(20, 10);
		assertEquals(2,actualResult);
	}
	
	@Test
	public void testDivWithException() {
		assertThrows(ArithmeticException.class, ()-> cal.div(20, 0));		
	}
	
}
