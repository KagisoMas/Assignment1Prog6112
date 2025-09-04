/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesmanagementapp;

/**
 *
 * @author lab_services_student
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList;
    private Scanner scanner;
    
    public Series() {
        seriesList = new ArrayList<>();
        scanner = new Scanner(System.in);
        
        // Add some sample data
        seriesList.add(new SeriesModel("101", "Extreme Sports", "12", "10"));
        seriesList.add(new SeriesModel("102", "Bargain Hunters", "10", "10"));
        seriesList.add(new SeriesModel("103", "Home Cooking", "10", "10"));
    }
    
    public void captureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");
        System.out.println("***********");
        
        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();
        
        String age;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            age = scanner.nextLine();
            
            if (isValidAge(age)) {
                break;
            } else {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            }
        }
        
        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = scanner.nextLine();
        
        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);
        
        System.out.println("Series processed successfully!!!");
    }
    
    private boolean isValidAge(String age) {
        try {
            int ageValue = Integer.parseInt(age);
            return ageValue >= 2 && ageValue <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public void searchSeries() {
        System.out.print("\nEnter the series id to search: ");
        String id = scanner.nextLine();
        
        SeriesModel foundSeries = null;
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(id)) {
                foundSeries = series;
                break;
            }
        }
        
        if (foundSeries != null) {
            System.out.println("---");
            System.out.println(foundSeries.toString());
            System.out.println("---");
        } else {
            System.out.println("---");
            System.out.println("Series with Series Id: " + id + " was not found!");
            System.out.println("---");
        }
    }
    
    public void updateSeries() {
        System.out.print("\nEnter the series id to update: ");
        String id = scanner.nextLine();
        
        SeriesModel foundSeries = null;
        int index = -1;
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).seriesId.equals(id)) {
                foundSeries = seriesList.get(i);
                index = i;
                break;
            }
        }
        
        if (foundSeries != null) {
            System.out.print("Enter the series name: ");
            String name = scanner.nextLine();
            
            String age;
            while (true) {
                System.out.print("Enter the age restriction: ");
                age = scanner.nextLine();
                
                if (isValidAge(age)) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            }
            
            System.out.print("Enter the number of episodes: ");
            String episodes = scanner.nextLine();
            
            seriesList.set(index, new SeriesModel(id, name, age, episodes));
            System.out.println("Series updated successfully!");
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }
    
    public void deleteSeries() {
        System.out.print("\nEnter the series id to delete: ");
        String id = scanner.nextLine();
        
        SeriesModel foundSeries = null;
        int index = -1;
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).seriesId.equals(id)) {
                foundSeries = seriesList.get(i);
                index = i;
                break;
            }
        }
        
        if (foundSeries != null) {
            System.out.print("Are you sure you want to delete series " + id + " from the system? (Y/N): ");
            String confirmation = scanner.nextLine();
            
            if (confirmation.equalsIgnoreCase("Y")) {
                seriesList.remove(index);
                System.out.println("Series with Series Id: " + id + " was deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }
    
    public void seriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available to display.");
            return;
        }
        
        System.out.println("\nSERIES REPORT");
        System.out.println("=============");
        
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel series = seriesList.get(i);
            System.out.println("Series " + (i + 1));
            System.out.println("---");
            System.out.println(series.toString());
            System.out.println("---");
        }
    }
    
    public void exitApplication() {
        System.out.println("Exiting application. Goodbye!");
        scanner.close();
        System.exit(0);
    }
    
    public void displayMenu() {
        System.out.println("\n---");
        System.out.println("LATEST SERIES - 2025");
        System.out.println("---");
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a series.");
        System.out.println("(3) Update series age restriction.");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report.");
        System.out.println("(6) Exit Application.");
        System.out.print("Enter your choice: ");
    }
    
    public void runApplication() {
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String input = scanner.nextLine();
        
        if (!input.equals("1")) {
            exitApplication();
        }
        
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    captureSeries();
                    break;
                case "2":
                    searchSeries();
                    break;
                case "3":
                    updateSeries();
                    break;
                case "4":
                    deleteSeries();
                    break;
                case "5":
                    seriesReport();
                    break;
                case "6":
                    exitApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println("\nEnter (1) to launch menu or any other key to exit");
            input = scanner.nextLine();
            
            if (!input.equals("1")) {
                exitApplication();
            }
        }
    }
}
