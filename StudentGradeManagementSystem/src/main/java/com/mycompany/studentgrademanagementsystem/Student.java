/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgrademanagementsystem;

/**
 *
 * @author lab_services_student
 */


// Student class inheriting from Person
public class Student extends Person {
    private int[] grades;
    private String course;
    
    public Student(String id, String name, String course, int[] grades) {
        super(id, name);
        this.course = course;
        this.grades = grades;
    }
    
    public String getCourse() { 
        return course; 
    }
    
    public int[] getGrades() { 
        return grades; 
    }
    
    public double calculateAverage() {
        return GradeCalculator.calculateAverage(grades);
    }
    
    public char calculateGrade() {
        return GradeCalculator.calculateGrade(calculateAverage());
    }
    
    @Override
    public void displayInfo() {
        System.out.printf("| %-8s | %-15s | %-10s | %-15s | %-8s | %-6s |\n", 
                          getId(), getName(), getCourse(), 
                          java.util.Arrays.toString(getGrades()), 
                          String.format("%.2f", calculateAverage()), 
                          calculateGrade());
    }
}