package com.vlad.cityadventure.classes;

import java.util.ArrayList;

/**
 * This is the user class, which will contain all of their achievements photos, etc
 * I think this will be useful to view other people in the app
 * If it is to be used to hold data on the actual user of the application,
 * might be a good idea to make it a singleton UserManager class to ensure there is just one instance of it
 *
 * I haven't (poorly attempted) to construct this one since you might want to do the singleton thing - Ally
 *
 * Should contain:
 *  - first_name
 *  - last_name
 *  - email
 *  - profile_picture
 *  - foursquare_id (for linking them to a Foursquare user acc/id?)
 *  - uncompleted_adventures
 *  - completed_adventures
 *  - completed_tasks
 *  - achievements (gained)
 *  - score
 *  - cities_visited
 *  - landmarks_visited
 */
public class User {
    private String firstName, lastName, email, currentAdventure, password;
    private int adventurePoints;//score
    private ArrayList<String> landmarks;
    private ArrayList<String> cities;
    private ArrayList<String> adventures;

    public User(String firstName, String lastName, String email, String currentAdventure, String password, int adventurePoints, ArrayList<String> landmarks, ArrayList<String> cities, ArrayList<String> adventures) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.currentAdventure = currentAdventure;
        this.password = password;
        this.adventurePoints = adventurePoints;
        this.landmarks = landmarks;
        this.cities = cities;
        this.adventures = adventures;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentAdventure() {
        return currentAdventure;
    }

    public void setCurrentAdventure(String currentAdventure) {
        this.currentAdventure = currentAdventure;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdventurePoints() {
        return adventurePoints;
    }

    public void setAdventurePoints(int adventurePoints) {
        this.adventurePoints = adventurePoints;
    }

    public ArrayList<String> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(ArrayList<String> landmarks) {
        this.landmarks = landmarks;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void setCities(ArrayList<String> cities) {
        this.cities = cities;
    }

    public ArrayList<String> getAdventures() {
        return adventures;
    }

    public void setAdventures(ArrayList<String> adventures) {
        this.adventures = adventures;
    }
}
