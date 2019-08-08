package com.github.bael.course.unit2.examples.inheritance;

public class Bike extends Vehicle {
    @Override
    public void move() {

        System.out.println("Running fast on my bike to " + destination);
    }
}
