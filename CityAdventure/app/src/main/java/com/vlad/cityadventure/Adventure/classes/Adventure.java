package com.vlad.cityadventure.Adventure.classes;

/**
 * Adventure class, has tasks associated with it
 * Will probably have a lot more info, like routes, task order, landmarks in the adventure (maybe?), etc
 */
import com.vlad.cityadventure.Adventure.classes.Landmark;
import com.vlad.cityadventure.Adventure.classes.Task;

import java.util.LinkedList;

public class Adventure {
    public LinkedList<Landmark> route;
    public LinkedList<Task> tasks;
}
