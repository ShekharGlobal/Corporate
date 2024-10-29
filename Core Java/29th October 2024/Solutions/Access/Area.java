package com.cognizant.shapes;

public class Area {
    public static void main(String[] args) {
        // Create an instance of Circle using the package-level constructor
        Circle circle = new Circle(2.5f);

        // Use the getRadius() method to access the radius value
        float radius = circle.getRadius();

        // Calculate and display area and circumference using the radius value obtained
        float area = circle.calculateCircleArea(radius);
        System.out.println("Area of the circle: " + area);

        float circumference = circle.calculateCircumference(radius);
        System.out.println("Circumference of the circle: " + circumference);
    }
}
