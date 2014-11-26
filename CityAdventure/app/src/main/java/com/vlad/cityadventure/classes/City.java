package com.vlad.cityadventure.classes;

/**
 * Pretty much a landmark, but it also contains many landmarks within it and has
 * adventures associated with it
 */

import java.util.ArrayList;

public class City extends Landmark {
    private String country;
    private ArrayList<String> landmarks;
    private ArrayList<String> adventures;

    public City(String url, int background, ArrayList<String> achievements, int icon, String name, String description, String type_of_venue, float latitude, float longitude, String city, ArrayList<String> tasks,
                ArrayList<Question> questions, int visitor_count, String country, ArrayList<String> landmarks, ArrayList<String> adventures) {
        super(url, background, achievements, icon, name, description, type_of_venue, latitude, longitude, city, tasks, questions, visitor_count);
        this.country = country;
        this.landmarks = landmarks;
        this.adventures = adventures;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<String> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(ArrayList<String> landmarks) {
        this.landmarks = landmarks;
    }

    public ArrayList<String> getAdventures() {
        return adventures;
    }

    public void setAdventures(ArrayList<String> adventures) {
        this.adventures = adventures;
    }
}
