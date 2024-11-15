package com.coforge.constructor;

public class Employee {

	private int id; 
	private String name;
	private Address address; 

	// Constructor for constructor-based injection
	public Employee(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public void display() {
		System.out.println(id + " " + name);
		System.out.println(address);
	}
}
