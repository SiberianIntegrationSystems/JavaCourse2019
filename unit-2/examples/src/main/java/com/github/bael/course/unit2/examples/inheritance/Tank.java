package com.github.bael.course.unit2.examples.inheritance;

import com.github.bael.course.unit2.examples.inheritance.interfaces.Armorable;
import com.github.bael.course.unit2.examples.inheritance.interfaces.Weaponable;

public class Tank extends Vehicle implements Weaponable, Armorable {
    @Override
    protected void move() {
        System.out.println("Crawling to " + destination);
    }

    @Override
    public void shoot() {
        System.out.println("Shooting!");
    }

    @Override
    public int getAttackLevel() {
        return Weaponable.super.getAttackLevel();
    }

    @Override
    public int getArmorDensity() {
        return 9000;
    }

    @Override
    public void takeHit() {
        System.out.println("Tank is taking hit!");

    }
}
