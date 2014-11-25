package com.vlad.cityadventure.classes;

import java.util.ArrayList;

/**
 * Has a list of tasks associated with it and could have like a list of people who have completed it
 * Has a point value and an image as well
 */
public class Achievement {
    public String name;
    public String description;
    public ArrayList<String> tasks;
    public int points;  //point value of completing the achievement
    // How do we attach an image to this class?


    public Achievement(String name, String description, ArrayList<String> tasks, int points) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
