package com.coforge.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class CheckedException2 {

	public static void main(String[] args)  {
		FileWriter fw = null;
		try {
		fw = new FileWriter("d:/coforge.txt");
		fw.write("Welcome to all participants");
		System.out.println("Success");
		}
		catch(IOException e) {
			System.out.println("Exception");
		}
		finally {
		try {
			fw.close();
		} catch (IOException e) {
			System.out.println("Exception Occoured");
		}
		}

	}

}
