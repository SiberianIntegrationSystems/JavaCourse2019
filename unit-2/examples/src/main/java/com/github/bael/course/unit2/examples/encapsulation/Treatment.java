package com.github.bael.course.unit2.examples.encapsulation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/*
Нарушение доступа к состоянию
* **/
public class Treatment {

    private LocalDateTime timeOfMedication;
    private boolean receivedMedication;
    private String medicationName;
    private int plannedQuantity;
    private int actualQuantity;

    public LocalDateTime getTimeOfMedication() {
        return timeOfMedication;
    }

    public void setTimeOfMedication(LocalDateTime timeOfMedication) {
        this.timeOfMedication = timeOfMedication;
    }


    public boolean isReceivedMedication() {
        return receivedMedication;
    }

    public void setReceivedMedication(boolean receivedMedication) {
        this.receivedMedication = receivedMedication;
        actualQuantity += plannedQuantity;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public int getPlannedQuantity() {
        return plannedQuantity;
    }

    public void setPlannedQuantity(int plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public int getActualQuantity() {
        return actualQuantity;
    }
    public void setActualQuantity(int actualQuantity) {
        this.actualQuantity = actualQuantity;
    }


}
