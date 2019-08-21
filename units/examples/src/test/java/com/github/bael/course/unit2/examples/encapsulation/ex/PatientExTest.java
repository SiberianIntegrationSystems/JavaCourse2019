package com.github.bael.course.unit2.examples.encapsulation.ex;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PatientExTest {

    @Test
    public void testGetters() {
        // ARRANGE
        LocalDateTime dateOfTreatment = LocalDateTime.of(2019, 8, 8, 10, 0, 0);
        // не пишем 0 перед цифрами - это восьмеричная система исчисления в java/ LocalDateTime.of(2019, 08, 08, 10, 0, 0)
        TreatmentEx treatmentEx = new TreatmentEx(dateOfTreatment, "glucose", 100);
        List<TreatmentEx> treatmentExesCourse = new ArrayList<>();
        treatmentExesCourse.add(treatmentEx);
        PatientEx patientEx = new PatientEx("Bruce Wayne", "Arkham #6", treatmentExesCourse,
                "never smiles", "dr. J. Oker");
        // ACT
        List<TreatmentEx> course = patientEx.getCourse();
        System.out.println("План лечения был такой: " + course);
        course.clear();
        System.out.println("А стал такой: "+ course);

        patientEx.treat();
        // ASSERT
        assertTrue(patientEx.isCured());
    }


    @Test
    public void testGettersUnmodified() {
        // ARRANGE
        LocalDateTime dateOfTreatment = LocalDateTime.of(2019, 8, 8, 10, 0, 0);
        // не пишем 0 перед цифрами - это восьмеричная система исчисления в java/ LocalDateTime.of(2019, 08, 08, 10, 0, 0)
        TreatmentEx treatmentEx = new TreatmentEx(dateOfTreatment, "laughing gas", 100);
        List<TreatmentEx> treatmentExesCourse = new ArrayList<>();
        treatmentExesCourse.add(treatmentEx);
        PatientEx patientEx = new PatientEx("Bruce Wayne", "Arkham #6", treatmentExesCourse,
                "never smiles", "dr. J. Oker");

        // ACT
        List<TreatmentEx> course = patientEx.getCourseUnmodifiedable();
        System.out.println("План лечения был такой: " + course);

        // ASSERT
        assertThrows(UnsupportedOperationException.class, () -> course.clear());
        patientEx.treat();
        System.out.println("А стал такой: "+ course);
        assertTrue(patientEx.isCured());
    }
}