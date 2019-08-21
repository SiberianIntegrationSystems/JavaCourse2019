package com.github.bael.course.unit2.examples.inheritance.interfaces;

public interface Weaponable {
    void shoot();

    default int getAttackLevel() {
        System.out.println("Can shoot with " + " 100 attack level");

        return 100;
    }
}
