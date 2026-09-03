package com.example.course_registration;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String studentId;

    private List<Subject> subjects;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.subjects = new ArrayList<>();
    }

    public void registerSubject(Subject subject) {
        subjects.add(subject);
    }

    public int calculateTotalCredits() {

        int totalCredits = 0;

        for (Subject subject : subjects) {
            totalCredits += subject.getCredits();
        }

        return totalCredits;
    }

    public boolean isEligible() {

        return calculateTotalCredits() >= 15;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}