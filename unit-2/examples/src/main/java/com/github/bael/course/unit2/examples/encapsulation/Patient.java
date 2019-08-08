package com.github.bael.course.unit2.examples.encapsulation;

import java.util.List;

public class Patient {

    private String name;
    private String room;

    public List<Treatment> getCourse() {
        return course;
    }

    public Patient(String name, String room, List<Treatment> course) {
        this.name = name;
        this.room = room;
        this.course = course;
    }

    private List<Treatment> course;

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }
}
