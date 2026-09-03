package com.example.course_registration;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     COURSE REGISTRATION SYSTEM");
        System.out.println("=================================");

        // Student details
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        while (name.isEmpty()) {
            System.out.println("Student name cannot be empty.");
            System.out.print("Enter student name: ");
            name = scanner.nextLine().trim();
        }

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();

        while (studentId.isEmpty()) {
            System.out.println("Student ID cannot be empty.");
            System.out.print("Enter student ID: ");
            studentId = scanner.nextLine().trim();
        }

        Student student = new Student(name, studentId);

        // Number of subjects
        int numberOfSubjects = readPositiveInteger(
                scanner,
                "Enter number of subjects: "
        );

        // Register subjects
        for (int i = 1; i <= numberOfSubjects; i++) {

            System.out.println("\nSubject " + i);

            System.out.print("Enter subject name: ");
            String subjectName = scanner.nextLine().trim();

            while (subjectName.isEmpty()) {
                System.out.println("Subject name cannot be empty.");
                System.out.print("Enter subject name: ");
                subjectName = scanner.nextLine().trim();
            }

            int credits = readPositiveInteger(
                    scanner,
                    "Enter credits: "
            );

            Subject subject = new Subject(
                    subjectName,
                    credits
            );

            student.registerSubject(subject);
        }

        // Display result
        System.out.println("\n=================================");
        System.out.println("       REGISTRATION SUMMARY");
        System.out.println("=================================");

        System.out.println("Student Name : " + student.getName());
        System.out.println("Student ID   : " + student.getStudentId());

        System.out.println("\nRegistered Subjects:");

        for (Subject subject : student.getSubjects()) {

            System.out.println(
                    "- " + subject.getName()
                    + " (" + subject.getCredits()
                    + " credits)"
            );
        }

        int totalCredits = student.calculateTotalCredits();

        System.out.println("\nTotal Credits: " + totalCredits);

        if (student.isEligible()) {

            System.out.println(
                    "Eligibility  : ELIGIBLE"
            );

        } else {

            System.out.println(
                    "Eligibility  : NOT ELIGIBLE"
            );
        }

        System.out.println(
                "Requirement  : Minimum 15 credits"
        );

        System.out.println("=================================");

        scanner.close();
    }

    private static int readPositiveInteger(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                int value = Integer.parseInt(input);

                if (value > 0) {
                    return value;
                }

                System.out.println(
                        "Please enter a number greater than 0."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a whole number."
                );
            }
        }
    }
}