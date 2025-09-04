/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgrademanagementsystem;

/**
 *
 * @author lab_services_student
 */


import java.util.ArrayList;

// Course class to manage students
public class Course {
    private String courseCode;
    private String courseName;
    private ArrayList<Student> students;
    
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }
    
    public void generateReport() {
        System.out.println("\n" + "=".repeat(90));
        System.out.println("COURSE REPORT: " + courseCode + " - " + courseName);
        System.out.println("=".repeat(90));
        System.out.printf("| %-8s | %-15s | %-10s | %-15s | %-8s | %-6s |\n", 
                          "ID", "Name", "Course", "Grades", "Average", "Grade");
        System.out.println("=".repeat(90));
        
        for (Student student : students) {
            student.displayInfo();
        }
        
        System.out.println("=".repeat(90));
        System.out.printf("| %-48s | %-8.2f | %-6s |\n", 
                          "CLASS AVERAGE", calculateClassAverage(), 
                          GradeCalculator.calculateGrade(calculateClassAverage()));
        System.out.println("=".repeat(90));
    }
    
    public double calculateClassAverage() {
        if (students.isEmpty()) return 0;
        double total = 0;
        for (Student student : students) {
            total += student.calculateAverage();
        }
        return total / students.size();
    }
}
