package org.example;

import java.util.*;
import java.util.logging.*;

public class StudentTest {

    public static void main(String[] args) {
        String id;
        String name;
        double gpa;
        int i;

        String format = " %2s | %-10s | %7s ";

        Scanner sc = new Scanner(System.in);
        Logger l = Logger.getLogger("com.api.jar");

        l.info("Enter the number of students");
        int numOfStudent = sc.nextInt();

        LinkedList<Student> studentList = new LinkedList<>();

        for (i = 0; i < numOfStudent; i++) {
            l.log(Level.INFO, () -> "Enter the Student ID ");
            id = sc.next();
            l.log(Level.INFO, () -> "Enter the Student Name ");
            name = sc.next();
            l.log(Level.INFO, () -> "Enter the Student GPA ");
            gpa = sc.nextDouble();
            studentList.add(new Student(id, name, gpa));
        }

        l.info("Before Sorting");

        for (i = 0; i < studentList.size(); i++) {
            String s1 = String.format(format, "ID: " + studentList.get(i).getId(), "Name: " + studentList.get(i).getName(), "GPA: " + studentList.get(i).getGPA());
            l.info(s1);
        }

        studentList.sort((s1, s2) -> {
            return Double.compare(s2.getGPA(), s1.getGPA());
        });

        l.info("After Sorting");

        for (i = 0; i < studentList.size(); i++) {
            String s1 = String.format(format, "ID: " + studentList.get(i).getId(), "Name: " + studentList.get(i).getName(), "GPA: " + studentList.get(i).getGPA());
            l.info(s1);
        }
    }
}