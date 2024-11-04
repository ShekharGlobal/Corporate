package com.coforge.exceptions;

public class ExampleThrows {

	public static void main(String[] args) {
		
		ThrowsDemo2 t1= new ThrowsDemo2();
		try {
		t1.div();
		}
		catch(ArithmeticException e) {
			System.out.println("Div by Zero");
		}

	}

}
