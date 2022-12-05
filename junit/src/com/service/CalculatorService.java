package com.service;

public class CalculatorService {

	public int sum(int a ,int b) {
		int result = a+b;
		return result;
	}	
	
	public int div(int a,int b) {
		
		if(b==0) {
			throw new ArithmeticException();
		}
		int c = a/b;		
		return c;
	}
}
