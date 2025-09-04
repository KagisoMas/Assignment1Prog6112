/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentgrademanagementsystem;

/**
 *
 * @author lab_services_student
 */

import java.util.Scanner;

// Main application class
public class StudentGradeManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Course currentCourse;
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("      STUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        
        initializeCourse();
        
        int choice;
        do {
            displayMenu();
            choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewReport();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
    
    private static void initializeCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        currentCourse = new Course(code, name);
        System.out.println("Course initialized successfully!\n");
    }
    
    private static void displayMenu() {
        System.out.println("\nMENU OPTIONS:");
        System.out.println("1. Add Student");
        System.out.println("2. Generate Report");
        System.out.println("3. Search Student");
        System.out.println("4. Exit");
    }
    
    private static void addStudent() {
        System.out.println("\nADD NEW STUDENT");
        System.out.println("-".repeat(40));
        
        String id = getStringInput("Enter student ID: ");
        String name = getStringInput("Enter student name: ");
        
        int numGrades = getIntInput("How many grades to enter? ");
        int[] grades = new int[numGrades];
        
        for (int i = 0; i < numGrades; i++) {
            grades[i] = getIntInput("Enter grade " + (i + 1) + " (0-100): ");
            // Validate grade input
            while (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                grades[i] = getIntInput("Enter grade " + (i + 1) + " (0-100): ");
            }
        }
        
        Student student = new Student(id, name, currentCourse.getCourseCode(), grades);
        currentCourse.addStudent(student);
        
        System.out.println("Student added successfully!");
    }
    
    private static void viewReport() {
        if (currentCourse != null && !currentCourse.getStudents().isEmpty()) {
            currentCourse.generateReport();
        } else {
            System.out.println("No student data available. Please add students first.");
        }
    }
    
    private static void searchStudent() {
        if (currentCourse == null || currentCourse.getStudents().isEmpty()) {
            System.out.println("No student data available. Please add students first.");
            return;
        }
        
        System.out.print("Enter student ID to search: ");
        String searchId = scanner.nextLine();
        
        boolean found = false;
        for (Student student : currentCourse.getStudents()) {
            if (student.getId().equalsIgnoreCase(searchId)) {
                System.out.println("\nSTUDENT FOUND:");
                System.out.println("-".repeat(40));
                System.out.printf("ID: %s\nName: %s\nCourse: %s\nGrades: %s\nAverage: %.2f\nGrade: %c\n",
                                 student.getId(), student.getName(), student.getCourse(),
                                 java.util.Arrays.toString(student.getGrades()),
                                 student.calculateAverage(), student.calculateGrade());
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }
    }
    
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
