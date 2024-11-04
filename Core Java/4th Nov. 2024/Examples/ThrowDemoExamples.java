package com.coforge.exceptions;

public class ThrowDemoExamples {
	
	public void div(){
		
		int x=10/2;
		
		System.out.println(x);
		throw new ArithmeticException();
	}

	public static void main(String[] args) {
		
		ThrowDemoExamples d1= new  ThrowDemoExamples();
		
		try {
			d1.div();
		}
		catch(ArithmeticException e) {
			System.out.println("div by zero");
		}

	}

}
