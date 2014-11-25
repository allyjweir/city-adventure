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
    public int points;
    public int icon;


    public Achievement(int icon, String name, String description, ArrayList<String> tasks, int points) {
        this.icon = icon;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.points = points;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
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
