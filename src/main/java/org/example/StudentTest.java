package org.example;

import java.util.*;
import java.util.logging.*;

class Student{
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        setId(id);
        setName(name);
        setGPA(gpa);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
            this.gpa = gpa;
    }

}

public class StudentTest {

    public static void main(String[] args) {
        String id;
        String name;
        double gpa;
        int i;

        String format = " %2s | %-10s | %7s0 ";

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

        Collections.sort(studentList, (s1, s2) -> {
            if (s1.getGPA() == s2.getGPA()) {
                return 0;
            }
            if (s1.getGPA() > s2.getGPA()) {
                return -1;
            }
            return 1;
        });

        l.info("After Sorting");

        for (i = 0; i < studentList.size(); i++) {
            String s1 = String.format(format, "ID: " + studentList.get(i).getId(), "Name: " + studentList.get(i).getName(), "GPA: " + studentList.get(i).getGPA());
            l.info(s1);
        }
    }
}