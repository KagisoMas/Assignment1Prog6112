/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgrademanagementsystem;

/**
 *
 * @author lab_services_student
 */


// Utility class for grade calculations
public class GradeCalculator {
    
    public static double calculateAverage(int[] grades) {
        if (grades == null || grades.length == 0) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
    
    public static char calculateGrade(double average) {
        if (average >= 80) return 'A';
        if (average >= 70) return 'B';
        if (average >= 60) return 'C';
        if (average >= 50) return 'D';
        return 'F';
    }
}
