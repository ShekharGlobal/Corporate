package com.coforge.exceptions;
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
        	/**
        	 * Occurs when trying to access an array with an illegal index 
        	 * (in this case, accessing args[0] when no argument is provided).
				This is an unchecked exception because it is a subclass of 
				RuntimeException.
        	 */
            int den = Integer.parseInt(args[0]);
            System.out.println(3 / den);
        } catch (ArrayIndexOutOfBoundsException ab) {
            // Exception a handled here
            System.out.println("Please provide a number as an argument.");
        } catch (ArithmeticException ar) {
            // Exception b handled here
            System.out.println("Division by zero is not allowed.");
        } catch (NumberFormatException nf) {
            // Exception c handled here
            System.out.println("Please provide a valid integer number.");
        }
    }
}
