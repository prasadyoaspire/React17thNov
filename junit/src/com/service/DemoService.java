package com.service;

import java.util.Arrays;

public class DemoService {

	public boolean  isPalindrom(int n) {
		
		int temp = n;
		int sum = 0;
		while(n>0) {
			int r = n%10;
			sum = (sum*10)+r;
			n = n/10;
		}
		
		if(temp == sum) {
			return true;
		}
		
		return false;	
	}
	
	public int[] sort(int[] input) {
		Arrays.sort(input);
		return input;
	}
	
	
}
