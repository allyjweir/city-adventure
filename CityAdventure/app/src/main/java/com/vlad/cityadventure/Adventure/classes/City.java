package com.vlad.cityadventure.Adventure.classes;

/**
 * Pretty much a landmark, but it also contains many landmarks within it and has
 * adventures associated with it
 */

import com.vlad.cityadventure.Adventure.classes.Adventure;

import java.util.ArrayList;

public class City extends Landmark {
    public String country;
    public ArrayList<Landmark> landmarks;
    public ArrayList<Adventure> adventures;

    public City(String name, String description, String type_of_venue, float latitude,
                float longitude, City city, ArrayList<Task> tasks,
                ArrayList<Question> questions, int visitor_count){
        super(name, description, type_of_venue, latitude, longitude, city, tasks,
                questions, visitor_count);
    }
}
