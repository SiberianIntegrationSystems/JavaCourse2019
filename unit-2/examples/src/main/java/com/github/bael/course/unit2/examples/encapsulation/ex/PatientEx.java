package com.github.bael.course.unit2.examples.encapsulation.ex;
import java.util.Collections;
import java.util.List;

public class PatientEx {

    private String name;
    private String room;
    private String diagnose;
    private String doctor;

    public List<TreatmentEx> getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "PatientEx{" +
                "name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", diagnose='" + diagnose + '\'' +
                ", doctor='" + doctor + '\'' +
                ", course=" + course +
                ", planTreatVolume=" + planTreatVolume +
                ", factTreatVolume=" + factTreatVolume +
                '}';
    }

    public PatientEx(String name, String room, List<TreatmentEx> course, String diagnose, String doctor) {
        this.name = name;
        this.room = room;
        this.course = course;
        this.diagnose = diagnose;
        this.doctor = doctor;
        for (TreatmentEx treatmentEx : course) {
            this.planTreatVolume += treatmentEx.getPlannedQuantity();
        }
    }

    private List<TreatmentEx> course;

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    private int planTreatVolume;
    private int factTreatVolume;

    // пациент вылечен, если получил запланированную дозу лекарств.
    public boolean isCured() {
        return planTreatVolume == factTreatVolume;
    }

    // Принимаем все назначенные лекарства
    public void treat() {
        for (TreatmentEx treatmentEx : course) {
            factTreatVolume += treatmentEx.treat();
        }
    }

    public List<TreatmentEx> getCourseUnmodifiedable() {
        return Collections.unmodifiableList(course);
    }
}
