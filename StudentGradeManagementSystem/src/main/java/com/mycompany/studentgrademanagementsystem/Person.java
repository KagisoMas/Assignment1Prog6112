/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgrademanagementsystem;

/**
 *
 * @author lab_services_student
 */


// Base abstract class for a Person
public abstract class Person {
    private String id;
    private String name;
    
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getters with information hiding
    public String getId() { 
        return id; 
    }
    
    public String getName() { 
        return name; 
    }
    
    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();
}
