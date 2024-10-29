
package com.coforge.fundamentals;

public class EmployeeTax {
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        TaxCalculator employee1 = new TaxCalculator();
        employee1.citizenship = true;
        employee1.basicSalary = 25000;
        employee1.calculateTax();
        employee1.deductTax();
        employee1.validateSalary();

        System.out.println();  

        // Test Case 2
        System.out.println("Test Case 2:");
        TaxCalculator employee2 = new TaxCalculator();
        employee2.citizenship = true;
        employee2.basicSalary = 125000;
        employee2.calculateTax();
        employee2.deductTax();
        employee2.validateSalary();
    }
}
