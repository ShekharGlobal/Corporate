package com.coforge.exceptions;

public class ThrowsDemo {

	public static void main(String[] args) {
		
		int result=0;
		Demo2 d1= new Demo2();
		try {
		d1.dividend=8;
		d1.divisor=0;
		
		result= d1.division();
		}
		
		catch(ArithmeticException e) {
			System.out.println("Exception" +e.getMessage());
		
		}
		finally {
			
			System.out.println(result);
		}

	}

}
