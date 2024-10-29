
package com.coforge.statement1;

public class Shapes {
    int numberOfSides;

    public void calculateShapeArea(int numberOfSides, int sideLength) {
        if (numberOfSides == 1) {
            Circle circle = new Circle(sideLength);
            circle.calculateArea();
        } else if (numberOfSides == 3) {
            Triangle triangle = new Triangle(sideLength);
            triangle.calculateArea();
        } else if (numberOfSides == 4) {
            Square square = new Square(sideLength);
            square.calculateArea();
        } else {
            System.out.println("No Shapes Present");
        }
    }

    public static void main(String[] args) {
        Shapes shape = new Shapes();

        // Test Case 1: Triangle with sides = 3, side length = 12
        System.out.println("Test Case 1:");
        shape.calculateShapeArea(3, 12);

        // Test Case 2: Square with sides = 4, side length = 15
        System.out.println("\nTest Case 2:");
        shape.calculateShapeArea(4, 15);

        // Test Case 3: No shape with sides = 5
        System.out.println("\nTest Case 3:");
        shape.calculateShapeArea(5, 15);
    }
}
