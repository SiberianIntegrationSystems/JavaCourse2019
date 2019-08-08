package com.github.bael.course.unit2.examples.overrideexample;

public class NuclearShell extends Shell {

    public void disarm(int level) {
        if (level > 10) {
            isSafe = true;
        }
    }

    public static void main(String[] args) {
        NuclearShell shell = new NuclearShell();
        shell.conserve();

        ArmorePiercingShell pierceShell = new ArmorePiercingShell();
        pierceShell.conserve();

    }
}
