/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesmanagementapp;

/**
 *
 * @author lab_services_student
 */
public class SeriesModel {
    public String seriesId;
    public String seriesName;
    public String seriesAge;
    public String seriesNumberOfEpisodes;
    
    public SeriesModel() {
        // Default constructor
    }
    
    public SeriesModel(String id, String name, String age, String episodes) {
        this.seriesId = id;
        this.seriesName = name;
        this.seriesAge = age;
        this.seriesNumberOfEpisodes = episodes;
    }
    
    @Override
    public String toString() {
        return "SERIES ID: " + seriesId + "\n" +
               "SERIES NAME: " + seriesName + "\n" +
               "SERIES AGE RESTRICTION: " + seriesAge + "\n" +
               "NUMBER OF EPISODES: " + seriesNumberOfEpisodes;
    }
}

