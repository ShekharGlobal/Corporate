// Shapes.java
package com.coforge.activity2;

public class Shapes {
    int numberOfSides;

    public void calculateShapeArea(int numberOfSides, int sideLength) {
        switch (numberOfSides) {
            case 1:
                Circle circle = new Circle(sideLength);
                circle.calculateArea();
                break;
            case 3:
                Triangle triangle = new Triangle(sideLength);
                triangle.calculateArea();
                break;
            case 4:
                Square square = new Square(sideLength);
                square.calculateArea();
                break;
            default:
                System.out.println("No Shapes Present");
                break;
        }
    }

    public static void main(String[] args) {
        Shapes shape = new Shapes();

        
        System.out.println("Test Case 1:");
        shape.calculateShapeArea(3, 12);


        System.out.println("\nTest Case 2:");
        shape.calculateShapeArea(4, 15);

       
        System.out.println("\nTest Case 3:");
        shape.calculateShapeArea(5, 15);
    }
}
