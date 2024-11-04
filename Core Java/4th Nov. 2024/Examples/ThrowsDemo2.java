package com.coforge.exceptions;

public class ThrowsDemo2 {
	
	public void div() throws ArithmeticException{
		
		int x=10/2;
		System.out.println(x);
	}

	public static void main(String[] args) {
		ThrowsDemo2 t1= new ThrowsDemo2();
		try {
		t1.div();
		}
		catch(ArithmeticException e) {
			System.out.println("div by zero");
		}
	}
	
}
