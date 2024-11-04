package com.coforge.exceptions;

public class ExceptionEx {
//unchecked Exception
	public static void main(String[] args) {
		try {
		int x[]= {5, 8, 9};
		
		System.out.println(x[3]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println("Invalid Index");
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
