package com.github.bael.course.unit2.examples.encapsulation.ex;

import java.time.LocalDateTime;

/*
Исправления:
избавились от сеттеров
действия через методы имеющие осмысленное название, и проверяющие состояние.
* **/
public class TreatmentEx {

    private LocalDateTime timeOfMedication;
    private boolean receivedMedication;
    private String medicationName;
    private int plannedQuantity;
    private int actualQuantity;

    public TreatmentEx(LocalDateTime timeOfMedication, String medicationName, int plannedQuantity) {
        this.timeOfMedication = timeOfMedication;
        this.medicationName = medicationName;
        this.plannedQuantity = plannedQuantity;
    }

    public LocalDateTime getTimeOfMedication() {
        return timeOfMedication;
    }

    public boolean isReceivedMedication() {
        return receivedMedication;
    }

    /**
     * Успешная медицинская процедура
     * */
    public int treat() {
        if (!receivedMedication) {
            this.receivedMedication = true;
            actualQuantity += plannedQuantity;
            return actualQuantity;
        }
        return 0;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public int getPlannedQuantity() {
        return plannedQuantity;
    }

    public int getActualQuantity() {
        return actualQuantity;
    }


    @Override
    public String toString() {
        return "TreatmentEx{" +
                "timeOfMedication=" + timeOfMedication +
                ", receivedMedication=" + receivedMedication +
                ", medicationName='" + medicationName + '\'' +
                ", plannedQuantity=" + plannedQuantity +
                ", actualQuantity=" + actualQuantity +
                '}';
    }
}
