package com.coforge.exceptions;

public class Demo3 {
	
	public void proc() throws ArithmeticException {
		
			int x=10;
			int y=2;
			int z=x/y;
			System.out.println(z);
			throw new ArithmeticException("Exception");
			
			}
			
	

	public static void main(String[] args)  {
		Demo3 d1= new Demo3();
		
	try {
		d1.proc();
	}
	catch(ArithmeticException e) {
		System.out.println("div by Zero");
	}
		
		
		//System.out.println("Rest of code....");

	}

}
