package com.github.bael.course.unit2.examples.inheritance.interfaces;

public interface Armorable {
    int getArmorDensity();

    void takeHit();

    default int getAttackLevel() {
        System.out.println("Can defence 100 attack level");

        return 100;
    }
}
