package com.vlad.cityadventure.Adventure.classes;

/**
 * Pretty much a landmark, but it also contains many landmarks within it and has
 * adventures associated with it
 */

import com.vlad.cityadventure.Adventure.classes.Adventure;

public class City extends Landmark {
    public String country;
    public ArrayList<Landmark> landmarks;
    public ArrayList<Adventure> adventures;
}
