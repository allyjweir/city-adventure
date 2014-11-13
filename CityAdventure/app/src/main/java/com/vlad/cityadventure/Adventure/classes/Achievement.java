package com.vlad.cityadventure.Adventure.classes;

/**
 * Has a list of tasks associated with it and could have like a list of people who have completed it
 * Has a point value and an image as well
 */
public class Achievement {
    public String name;
    public String description;
    public boolean badge;
    public boolean challenge;
    public String[] requirements;  // Left general to allow for mix of questions and tasks?
    public int points;  //point value of completing the achievement
    // How do we attach an image to this class?


    // Haven't auto generated the code since the image field hasn't been finalised.
}
