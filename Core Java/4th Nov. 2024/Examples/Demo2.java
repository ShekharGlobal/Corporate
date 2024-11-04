package com.coforge.exceptions;

public class Demo2 {

	int dividend;
	int divisor;
	
	public int division() throws ArithmeticException{
		
		if(divisor==0) {
			throw new  ArithmeticException("Divisor cannot be blank");
		}
		
		int result = dividend/divisor;
		return result;
	}
}
