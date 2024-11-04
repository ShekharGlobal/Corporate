package com.coforge.exceptions;

public class TrycatchFinally {
	public void divide(int a,int b){
		int quotient=0; 
		try{
		 quotient=a/b;
		}
		catch(ArithmeticException exception){
			
		 System.out.println("Exception Occurred"+exception.getMessage());
		}
		finally{
		 System.out.println("The quotient is "+quotient);
		}
		}

	public static void main(String[] args) {
		TrycatchFinally tcf= new TrycatchFinally();
		tcf.divide(10, 0);
	}

}
