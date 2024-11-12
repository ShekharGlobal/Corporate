package com.coforge.orm;

public class Main {

    public static void main(String[] args) {
        CRUD crud = new CRUD();

        // Insert Operation
        crud.insertEmployee(145, "Vijay", "R");

        // Select Operation
        crud.selectEmployee(145);

        // Update Operation
        //crud.updateEmployee(145, "Kumar");

        // Select to verify update
       // crud.selectEmployee(145);

        // Delete Operation
        crud.deleteEmployee(145);

        // Select to verify delete
        crud.selectEmployee(145);

        // Close the factory after all operations
        CRUD.closeFactory();
    }
}
