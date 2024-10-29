// Triangle.java
package com.coforge.activity2;

public class Triangle {
    int sides;

    public Triangle(int sides) {
        this.sides = sides;
    }

    public void calculateArea() {
        double area = 0.433 * sides * sides;
        System.out.println("The Area of the Triangle is " + area);
    }
}
