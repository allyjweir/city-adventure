package com.vlad.cityadventure.classes;

/**
 * Adventure class, has tasks associated with it
 * Will probably have a lot more info, like routes, task order, landmarks in the adventure (maybe?), etc
 */

import java.util.LinkedList;

public class Adventure {
    public LinkedList<Landmark> route;
    public LinkedList<Task> tasks;

    public LinkedList<Landmark> getRoute() {
        return route;
    }

    public void setRoute(LinkedList<Landmark> route) {
        this.route = route;
    }

    public LinkedList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(LinkedList<Task> tasks) {
        this.tasks = tasks;
    }
}
