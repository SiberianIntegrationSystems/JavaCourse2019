package com.github.bael.course.unit2.examples;

import com.github.bael.course.unit2.examples.encapsulation.Treatment;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreatmentTest {

    /**
     * Сеттеры нарушают инкапсуляцию
     */
    @Test
    public void testTreatmentCase1WrongSetters() {
        // готовим класс к работе
        Treatment t = new Treatment();
        t.setPlannedQuantity(100);
        t.setMedicationName("glucose");
        t.setTimeOfMedication(LocalDateTime.of(2019, 8, 8, 10, 10, 0));


        // действуем
        t.setReceivedMedication(true);
        t.setReceivedMedication(false);
        t.setReceivedMedication(true);


        // проверяем
        assertEquals(100, t.getActualQuantity());
    }



}