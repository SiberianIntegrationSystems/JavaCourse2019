package com.github.bael.course.unit2.examples.polimorfism;

import com.github.bael.course.unit2.examples.inheritance.Bike;
import com.github.bael.course.unit2.examples.inheritance.Plane;
import com.github.bael.course.unit2.examples.inheritance.Tank;
import com.github.bael.course.unit2.examples.inheritance.Vehicle;
import com.github.bael.course.unit2.examples.inheritance.interfaces.Armorable;

public class Example {
    public static void main(String[] args) {
        new Example().viaClasses();
        new Example().viaInterfaces();
    }

    public void viaClasses() {
        Vehicle vehicle = getVehicle("Paris");
        vehicle.travel("Paris");

        vehicle = getVehicle("berlin");
        vehicle.travel("Berlin");

        vehicle = getVehicle("moscow");
        vehicle.travel("moscow");

    }

    public void viaInterfaces() {
        Armorable armorable = new Tank();
        armorable.takeHit();
    }

    private Vehicle getVehicle(String destination) {
        if (destination.toLowerCase().equals("paris")) {
            return new Bike();
        } else if (destination.toLowerCase().equals("berlin")) {
            return new Tank();
        }

        return new Plane();
    }
}
