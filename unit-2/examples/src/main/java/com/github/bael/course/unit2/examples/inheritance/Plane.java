package com.github.bael.course.unit2.examples.inheritance;

public class Plane extends Vehicle {
    @Override
    public void move() {
        System.out.println("Flying high to " + destination);
    }
}
