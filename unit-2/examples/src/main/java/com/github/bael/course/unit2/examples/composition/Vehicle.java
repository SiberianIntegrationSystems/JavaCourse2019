package com.github.bael.course.unit2.examples.composition;

public class Vehicle {
    private MovePlatform movePlatform;

    public void move(MovePlatform movePlatform) {
        System.out.println("Abstract move");
    }

    public void move(GroundPlatform movePlatform) {
        System.out.println("Move on ground");
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.move(new GroundPlatform());

        MovePlatform platform = new GroundPlatform();
        v.move(platform);
    }
}
