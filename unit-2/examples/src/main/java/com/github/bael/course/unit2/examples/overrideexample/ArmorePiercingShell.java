package com.github.bael.course.unit2.examples.overrideexample;

public class ArmorePiercingShell extends Shell {

    public void disarm(int level) {
        if (level > 10) {
            isSafe = true;
        }
    }

    public static void main(String[] args) {
        ArmorePiercingShell shell = new ArmorePiercingShell();
        shell.conserve();
    }

    @Override
    public void disarm() {
        isSafe = true;
    }
}
