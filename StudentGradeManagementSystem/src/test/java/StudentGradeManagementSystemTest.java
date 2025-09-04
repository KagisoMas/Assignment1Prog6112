/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.studentgrademanagementsystem.Course;
import com.mycompany.studentgrademanagementsystem.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */


// Unit Tests for the application
public class StudentGradeManagementSystemTest {
    
    @Test
    public void testStudentAverageCalculation() {
        int[] grades = {85, 90, 78, 92};
        Student student = new Student("S001", "John Doe", "PROG6112", grades);
        
        double expectedAverage = (85 + 90 + 78 + 92) / 4.0;
        double actualAverage = student.calculateAverage();
        
        assertEquals("Average calculation test failed", expectedAverage, actualAverage);
    }
    
    @Test
    public void testStudentGradeCalculationA() {
        int[] grades = {85, 90, 78, 92}; // Average = 86.25
        Student student = new Student("S001", "John Doe", "PROG6112", grades);
        
        char expectedGrade = 'A';
        char actualGrade = student.calculateGrade();
        
        assertEquals("Grade A calculation test failed", expectedGrade, actualGrade);
    }
    
    @Test
    public void testStudentGradeCalculationB() {
        int[] grades = {75, 70, 68, 72}; // Average = 71.25
        Student student = new Student("S002", "Jane Smith", "PROG6112", grades);
        
        char expectedGrade = 'B';
        char actualGrade = student.calculateGrade();
        
        assertEquals("Grade B calculation test failed", expectedGrade, actualGrade);
    }
    
    @Test
    public void testStudentGradeCalculationF() {
        int[] grades = {45, 30, 40, 35}; // Average = 37.5
        Student student = new Student("S003", "Bob Johnson", "PROG6112", grades);
        
        char expectedGrade = 'F';
        char actualGrade = student.calculateGrade();
        
        assertEquals("Grade F calculation test failed", expectedGrade, actualGrade);
    }
    
    @Test
    public void testCourseAverageCalculation() {
        Course course = new Course("PROG6112", "Programming");
        
        int[] grades1 = {80, 85, 90};
        Student student1 = new Student("S001", "John Doe", "PROG6112", grades1);
        
        int[] grades2 = {70, 75, 80};
        Student student2 = new Student("S002", "Jane Smith", "PROG6112", grades2);
        
        course.addStudent(student1);
        course.addStudent(student2);
        
        double expectedAverage = (student1.calculateAverage() + student2.calculateAverage()) / 2;
        double actualAverage = course.calculateClassAverage();
        
        assertEquals("Course average calculation test failed", expectedAverage, actualAverage);
    }
    
    @Test
    public void testEmptyGrades() {
        int[] grades = {};
        Student student = new Student("S004", "Empty Grades", "PROG6112", grades);
        
        double expectedAverage = 0;
        double actualAverage = student.calculateAverage();
        
        assertEquals("Empty grades test failed", expectedAverage, actualAverage);
    }
    
    @Test
    public void testSingleGrade() {
        int[] grades = {95};
        Student student = new Student("S005", "Single Grade", "PROG6112", grades);
        
        double expectedAverage = 95;
        double actualAverage = student.calculateAverage();
        
        assertEquals("Single grade test failed", expectedAverage, actualAverage);
    }

    private void assertEquals(String empty_grades_test_failed, char expectedAverage, char actualAverage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String average_calculation_test_failed, double expectedAverage, double actualAverage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
