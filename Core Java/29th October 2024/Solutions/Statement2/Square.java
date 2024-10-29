// Square.java
package com.coforge.activity2;

public class Square {
    int sides;

    public Square(int sides) {
        this.sides = sides;
    }

    public void calculateArea() {
        int area = sides * sides;
        System.out.println("The Area of the Square is " + area);
    }
}
