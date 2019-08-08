package com.github.bael.course.unit2.examples.overrideexample;

public class Shell {
    boolean isSafe;
    public void disarm() {  }
    public void conserve() {
        disarm();
        if (!isSafe) { System.out.println("BOOOOOM"); }
        else { System.out.println("Shell conserved"); }
    }
}
