package com.vlad.cityadventure.utils;

/**
 * Created by Vladislavs on 22/11/2014.
 * This is a singleton that contains user data
 */

import com.vlad.cityadventure.classes.Adventure;
import com.vlad.cityadventure.classes.City;
import com.vlad.cityadventure.classes.Landmark;
import com.vlad.cityadventure.classes.Question;
import com.vlad.cityadventure.classes.Task;
import com.vlad.cityadventure.classes.User;

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
public class UserManager {

    private static UserManager instance;

    private User user;

    protected UserManager() {

    }

    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
