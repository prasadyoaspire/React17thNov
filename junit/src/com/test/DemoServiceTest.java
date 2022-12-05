package com.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.service.DemoService;

public class DemoServiceTest {

	@Test
	void testIsPalindromTrue() {
		DemoService demoService = new DemoService();
		boolean actualResult = demoService.isPalindrom(12321);
		assertTrue(actualResult);
	}
	
	@Test
	void testIsPalindromFalse() {
		DemoService demoService = new DemoService();
		boolean actualResult = demoService.isPalindrom(12345);
		assertFalse(actualResult);
	}
	
	@Test
	void testSort() {
		DemoService demoService = new DemoService();
		
//		int[] inputAry = {25,15,10,58,40};
//		int[] actualResult = demoService.sort(inputAry);
//		int[] expectedResult = {10,15,25,40,58};		
//		assertArrayEquals(expectedResult,actualResult);		
		
		int[] actualResult = demoService.sort(new int[]{25,15,10,58,40});
		assertArrayEquals(new int[]{10,15,25,40,58},actualResult);	
	}
}
