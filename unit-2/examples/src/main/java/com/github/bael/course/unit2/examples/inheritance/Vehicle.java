package com.github.bael.course.unit2.examples.inheritance;

/*
* Транспортное средство
* */
public abstract class Vehicle {
    private int velocity;
    private int weight;
    protected String destination;

    protected abstract void move();
    public void travel(String destination) {
        this.destination = destination;
        move();
    }
}
