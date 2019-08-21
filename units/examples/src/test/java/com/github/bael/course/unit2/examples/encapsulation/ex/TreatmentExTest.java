package com.github.bael.course.unit2.examples.encapsulation.ex;



import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TreatmentExTest {

    @Test
    public void testModification() {
        // ARRANGE
        LocalDateTime dateOfTreatment = LocalDateTime.of(2019, 8, 8, 10, 0, 0);
        // не пишем 0 перед цифрами - это восьмеричная система исчисления в java/ LocalDateTime.of(2019, 08, 08, 10, 0, 0)
        TreatmentEx treatmentEx = new TreatmentEx(dateOfTreatment, "glucose", 100);

        // ACT
        treatmentEx.treat();
        treatmentEx.treat();

        // ASSERT
        assertEquals(100, treatmentEx.getActualQuantity());

    }
}