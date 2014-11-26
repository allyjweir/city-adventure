package com.vlad.cityadventure.classes;

/**
 * Adventure class, has tasks associated with it
 * Will probably have a lot more info, like routes, task order, landmarks in the adventure (maybe?), etc
 */

public class Adventure {
    public String title;
    public String description;
    public String[] route;
    public String[] tasks;
    public int icon;

    public Adventure(int icon, String title, String description, String[] route, String[] tasks) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.route = route;
        this.tasks = tasks;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getRoute() {
        return route;
    }

    public void setRoute(String[] route) {
        this.route = route;
    }

    public String[] getTasks() {
        return tasks;
    }

    public void setTasks(String[] tasks) {
        this.tasks = tasks;
    }
}
