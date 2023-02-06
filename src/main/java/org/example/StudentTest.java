package org.example;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.*;

class Student{
    private String id;
    private String name;
    private double gpa;

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

    public Student(String id, String name, double gpa) {
        setId(id);
        setName(name);
        setGPA(gpa);
    }

}

public class StudentTest {

    public static void main(String[] args) {
        String id;
        String name;
        double gpa;

        Scanner sc=new Scanner(System.in);
        Logger l=Logger.getLogger("com.api.jar");

        l.info("Enter the number of students");
        int numOfStudent=sc.nextInt();

        LinkedList<Student> studentList = new LinkedList<>();

        for (int i = 0; i < numOfStudent; i++) {
            int finalI = i;
            l.log(Level.INFO,()->"Enter the Student ID "+ finalI);
            id=sc.next();
            l.log(Level.INFO,()->"Enter the Student Name "+ finalI);
            name=sc.next();
            l.log(Level.INFO,()->"Enter the Student GPA "+ finalI);
            gpa=sc.nextDouble();
            studentList.add(new Student( id,name,gpa));
        }

        studentList.sort((o1, o2) -> {
            if (o1.getGPA() == o2.getGPA()) {
                return 0;
            }
            if (o1.getGPA() > o2.getGPA()) {
                return -1;
            }
            return 1;

        });

        String format = " %2s | %-10s | %7s0 ";

        for (int i = 0; i < studentList.size(); i++) {
            String s1=String.format(format,"ID: "+studentList.get(i).getId(), "Name: "+studentList.get(i).getName(), "GPA: "+studentList.get(i).getGPA());
            l.info(s1);
        }

    }
}