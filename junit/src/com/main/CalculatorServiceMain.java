package com.main;

import com.service.CalculatorService;

public class CalculatorServiceMain {

	public static void main(String[] args) {
		
		CalculatorService cal = new CalculatorService();
		int result = cal.sum(0, 0);
		System.out.println("Sum: "+result);
	}
}
