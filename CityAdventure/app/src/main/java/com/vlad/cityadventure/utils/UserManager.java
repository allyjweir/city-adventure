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

    private String firstName, lastName, email;
    private int adventurePoints;//score
    private ArrayList<Landmark> landmarks;
    private ArrayList<City> cities;
    private ArrayList<Adventure> adventures;

    protected UserManager() {
        /**right all of this is mocked in the future, should be accessed from the server*/
        firstName = "Vlad";
        lastName = "Z";
        adventurePoints = 1250;
        cities = new ArrayList<City>();
        cities.add(new City("Glasgow", "Glasgow is the largest city in Scotland, and the third largest in the United Kingdom." +
                " At the 2011 census, it had a population density of 8,790 per square mile (3,390/km2), " +
                "the highest of any Scottish city. It is situated on the River Clyde in the country's West Central Lowlands. Inhabitants of the city are referred to as Glaswegians.",
                "city", (float) 55.85, (float) 4.25, null, new ArrayList<Task>(), new ArrayList<Question>(), 932929));
        cities.add(new City("Edinburgh", "Edinburgh is the capital city of Scotland, situated in Lothian on the southern shore of the Firth of Forth. It is the second most populous city" +
                " in Scotland and the seventh most populous in the United Kingdom. The population in 2013 was 487,500. Edinburgh lies at the heart of a Larger urban zone with" +
                " a population of 778,000.",
                "city", (float) 55.95, (float) 3.18, null, new ArrayList<Task>(), new ArrayList<Question>(), 9941198));
    }
    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
}
