package com.example.course_registration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    @Test
    void testTotalCredits() {

        Student student = new Student("Rahul", "24MIS0290");

        student.registerSubject(new Subject("Java", 5));
        student.registerSubject(new Subject("DBMS", 5));
        student.registerSubject(new Subject("Software Testing", 5));

        assertEquals(15, student.calculateTotalCredits());
    }

    @Test
    void testEligibleWhenCreditsAre15() {

        Student student = new Student("Rahul", "24MIS0290");

        student.registerSubject(new Subject("Java", 5));
        student.registerSubject(new Subject("DBMS", 5));
        student.registerSubject(new Subject("Software Testing", 5));

        assertTrue(student.isEligible());
    }

    @Test
    void testNotEligibleWhenCreditsAreLessThan15() {

        Student student = new Student("Priya", "24MIS0300");

        student.registerSubject(new Subject("Java", 5));
        student.registerSubject(new Subject("DBMS", 5));

        assertEquals(10, student.calculateTotalCredits());

        assertFalse(student.isEligible());
    }

    @Test
    void testMoreThan15Credits() {

        Student student = new Student("Amit", "24MIS0310");

        student.registerSubject(new Subject("Java", 6));
        student.registerSubject(new Subject("DBMS", 6));
        student.registerSubject(new Subject("Testing", 6));

        assertEquals(18, student.calculateTotalCredits());

        assertTrue(student.isEligible());
    }

    @Test
    void testSubjectDetails() {

        Subject subject = new Subject(
                "Software Engineering",
                4
        );

        assertEquals(
                "Software Engineering",
                subject.getName()
        );

        assertEquals(
                4,
                subject.getCredits()
        );
    }
}