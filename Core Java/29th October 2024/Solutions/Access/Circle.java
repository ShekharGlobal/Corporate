package com.cognizant.shapes;

public class Circle {
    
    private float radius;  // Restricted to class level
    float pi;  // Package-level access

    
    public Circle() {
        this.radius = 1.5f;
        this.pi = 3.5f; // Setting a default value to pi
    }

    
    Circle(float radius) {
        this(radius, 3.5f);  // Chaining to Constructor 3
    }

   
    private Circle(float radius, float pi) {
        this.radius = radius;
        this.pi = pi;
    }

 
    public float getRadius() {
        return this.radius;
    }

    
    public float calculateCircleArea(float radius) {
        return pi * radius * radius;
    }

    
    public float calculateCircumference(float radius) {
        return 2 * pi * radius;
    }

    
    public static void main(String[] args) {
        
        Circle circle = new Circle();

        
        float area = circle.calculateCircleArea(circle.getRadius());
        System.out.println("Area of the circle: " + area);

        float circumference = circle.calculateCircumference(circle.getRadius());
        System.out.println("Circumference of the circle: " + circumference);
    }
}
