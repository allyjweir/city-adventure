package com.vlad.cityadventure.utils;

/**
 * Created by Vladislavs on 22/11/2014.
 * This is a singleton that contains user data
 */

import com.vlad.cityadventure.R;
import com.vlad.cityadventure.classes.Achievement;
import com.vlad.cityadventure.classes.Adventure;
import com.vlad.cityadventure.classes.City;
import com.vlad.cityadventure.classes.Landmark;
import com.vlad.cityadventure.classes.Question;
import com.vlad.cityadventure.classes.Task;
import com.vlad.cityadventure.classes.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MockDatabase {

    private static MockDatabase instance;

    private HashMap<String, User> users = new HashMap<String, User>();
    private HashMap<String, City> cities = new HashMap<String, City>();
    private HashMap<String, Landmark> landmarks = new HashMap<String, Landmark>();
    private HashMap<String, Achievement> achievements = new HashMap<String, Achievement>();
    private HashMap<String, Adventure> adventures = new HashMap<String, Adventure>();
    private HashMap<String, Task> tasks = new HashMap<String, Task>();

    protected MockDatabase() {

        users.put("vladz", new User(new ArrayList<String>(), "Vlad", "Zaharovs", "vlad@cityadventure.com", "UKGLAHA01", "password", 300,
                new ArrayList<String>(Arrays.asList("UKGLAKELVINGROVE,UKGLARIVERSIDEMUS,UKGLAHUNTERIAN,UKGLAUNIGLASGOW".split(","))),//landmarks
                new ArrayList<String>(Arrays.asList("UKGLA,UKEDI".split(","))),//cities
                new ArrayList<String>(Arrays.asList("UKGLAHA01".split(",")))));//adventures));
        users.get("vladz").getCompleteTasks().add("UKGLAKELVINGROVE001");
        users.put("allyweir", new User(new ArrayList<String>(), "Ally", "Weir", "ally@cityadventure.com", "UKGLAHA01", "password", 300,
                new ArrayList<String>(Arrays.asList("UKGLAKELVINGROVE,UKGLAHILLHEADSUB,UKGLAUNIGLASGOW".split(","))),//landmarks
                new ArrayList<String>(Arrays.asList("UKGLA".split(","))),//cities
                new ArrayList<String>(Arrays.asList("UKGLAHA01".split(",")))));//adventures))

        landmarks.put("UKGLAKELVINGROVE", new Landmark(new ArrayList<String>(Arrays.asList("AAAA001,AAAA002,AAAA003,AAAA004,AAAA005".split(","))),
                R.drawable.landmark_general, "Kelvingrove Art Gallery and Museum", "The Kelvingrove Art Gallery and Museum is a museum and art gallery in Glasgow, Scotland.",
                "museum", (float) 55.8686, (float) -4.2905, "UKGLA",
                new ArrayList<String>(Arrays.asList(("UKGLAKELVINGROVE001,UKGLAKELVINGROVE002,UKGLAKELVINGROVE003,UKGLAKELVINGROVE004," +
                        "UKGLAKELVINGROVE005,UKGLAKELVINGROVE006,UKGLAKELVINGROVE007,UKGLAKELVINGROVE008,UKGLAKELVINGROVE009,UKGLAKELVINGROVE010,UKGLAKELVINGROVE011").split(","))),
                null, 1037594));
        landmarks.put("UKGLAHILLHEADSUB", new Landmark(new ArrayList<String>(Arrays.asList("AAAA001,AAAA002,AAAA003,AAAA004,AAAA005".split(","))),
                R.drawable.landmark_outdoors, "Hillhead Subway Station", "Hillhead subway station is a station on the Glasgow Subway, serving the Hillhead area of Glasgow, Scotland.",
                "transport", (float) 55.875833, (float) -4.292222, "UKGLA",
                new ArrayList<String>(Arrays.asList(("UKGLAHILLHEADSUB001,UKGLAHILLHEADSUB002,UKGLAHILLHEADSUB003,UKGLAHILLHEADSUB004" +
                        ",UKGLAHILLHEADSUB005").split(","))), null, 27997));
        landmarks.put("UKGLAHUNTERIAN", new Landmark(new ArrayList<String>(Arrays.asList("AAAA001,AAAA002,AAAA003,AAAA004,AAAA005".split(","))),
                R.drawable.landmark_outdoors, "Hunterian Museum and Art Gallery",
                "The University of Glasgow's Hunterian is the oldest museum in Scotland. It covers The Hunterian Museum, The Hunterian Art Gallery, The Mackintosh House, " +
                        "The Zoology Museum and The Anatomy Museum, all located in various buildings on the main campus of the University in the west end of Glasgow.",
                "museum", (float) 55.871944, (float) -4.288611, "UKGLA", null, null, 327157));
        landmarks.put("UKGLARIVERSIDEMUS", new Landmark(new ArrayList<String>(Arrays.asList("AAAA001,AAAA002,AAAA003,AAAA004,AAAA005".split(","))),
                R.drawable.landmark_general, "Riverside Museum",
                "The Riverside Museum is a new development for the Glasgow Museum of Transport, completed on 20 June 2011, at Pointhouse Quay in the Glasgow " +
                        "Harbour regeneration district of Glasgow, Scotland.",
                "museum", (float) 55.8651, (float) -4.30638, "UKGLA", null, null, 740276));
        landmarks.put("UKGLAUNIGLASGOW", new Landmark(new ArrayList<String>(Arrays.asList("AAAA001,AAAA002,AAAA003,AAAA004,AAAA005".split(","))),
                R.drawable.landmark_outdoors, "University of Glasgow",
                "The University of Glasgow is the fourth-oldest university in the English-speaking world and one of Scotland's four ancient universities.",
                "education", (float) 55.871944, (float) -4.2875, "UKGLA", null, null, 947541));




        cities.put("UKGLA", new City(new ArrayList<String>(Arrays.asList("AAAA001,AAAA002,AAAA003,AAAA004,AAAA005".split(","))),
                R.drawable.landmark_outdoors, "Glasgow", "Glasgow is the largest city in Scotland, and the third largest in the United Kingdom." +
                " At the 2011 census, it had a population density of 8,790 per square mile (3,390/km2), " +
                "the highest of any Scottish city. It is situated on the River Clyde in the country's West Central Lowlands. Inhabitants of the city are referred to as Glaswegians.",
                "city", (float) 55.858, (float) -4.259, "UKGLA",
                new ArrayList<String>(),
                new ArrayList<Question>(),
                2994627, "UK",
                new ArrayList<String>(Arrays.asList("UKGLAKELVINGROVE,UKGLARIVERSIDEMUS,UKGLAHUNTERIAN,UKGLAUNIGLASGOW,UKGLAHILLHEADSUB".split(","))),
                new ArrayList<String>(Arrays.asList("UKGLAHA01".split(",")))));
        cities.put("UKEDI", new City(new ArrayList<String>(Arrays.asList("AAAA001,AAAA002,AAAA003,AAAA004,AAAA005".split(","))),
                R.drawable.landmark_outdoors,"Edinburgh", "Edinburgh is the capital city of Scotland, situated in Lothian on the southern shore of the Firth of Forth. It is the second most populous city" +
                " in Scotland and the seventh most populous in the United Kingdom. The population in 2013 was 487,500. Edinburgh lies at the heart of a Larger urban zone with" +
                " a population of 778,000.",
                "city", (float) 55.95, (float) 3.18, "EDI",  new ArrayList<String>(),
                new ArrayList<Question>(), 2850000, "UK", new ArrayList<String>(), new ArrayList<String>()));

        achievements.put("AAAA001", new Achievement(R.drawable.achievement_chat,"City Adventurer", "The simplest of achievements",
                new ArrayList<String>(), 20));
        achievements.put("AAAA002", new Achievement(R.drawable.achievement_selfie,"Elephant Adventurer", "The simplest of achievements",
                new ArrayList<String>(), 20));
        achievements.put("AAAA003", new Achievement(R.drawable.elephant_achievement,"Glasgow Adventurer", "The simplest of achievements",
                new ArrayList<String>(), 20));
        achievements.put("AAAA004", new Achievement(R.drawable.achievement_selfie,"Transport Adventurer", "The simplest of achievements",
                new ArrayList<String>(), 20));
        achievements.put("AAAA005", new Achievement(R.drawable.achievement_chat,"Yet Another Adventurer", "The simplest of achievements",
                new ArrayList<String>(), 20));



        adventures.put("UKGLAHA01", new Adventure("Glasgow Historic", "A little adventure example", "UKGLAKELVINGROVE,UKGLARIVERSIDEMUS,UKGLAHUNTERIAN,UKGLAUNIGLASGOW".split(","),
        null));

        tasks.put("UKGLAKELVINGROVE001", new Task.QuestionTask("Answer question #1", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "Sir Roger,Sir David,Sir Remmy,Sir Ballantyne".split(","),
                0,"What is the name of the large elephant housed here?"));
        tasks.put("UKGLAKELVINGROVE002", new Task.QuestionTask("Answer question #2", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "Seahawk,Blackburn Ripon,Spitfire,Airspeed Oxford".split(","),
                2,"What WWII aircraft is suspended from the roof?"));
        tasks.put("UKGLAKELVINGROVE003", new Task.QuestionTask("Answer question #3", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "Cello,Bagpipes,Piano,Organ".split(","),
                3,"Which instrument is performed on everyday in the museum?"));
        tasks.put("UKGLAKELVINGROVE004", new Task.QuestionTask("Answer question #4", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "55,32,16,27".split(","),
                2,"How many heads are suspended in the Expression gallery?"));
        tasks.put("UKGLAKELVINGROVE005", new Task.QuestionTask("Answer question #5", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "1901,1066,1921,1898".split(","),
                0,"Which year was the museum opened?"));
        tasks.put("UKGLAKELVINGROVE006", new Task.QuestionTask("Answer question #6", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "Newspaper story,Bible,A Dream,Cloudspotting".split(","),
                2,"Where did Salvador Dalí get his influence for \"Christ of Saint John of the Cross\"?"));
        tasks.put("UKGLAKELVINGROVE007", new Task.QuestionTask("Answer question #7", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "8,55,24,14".split(","),
                2,"How many birds are in the museum"));
        tasks.put("UKGLAKELVINGROVE008", new Task.QuestionTask("Answer question #8", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "5,2,1,6".split(","),
                1,"How many Polar Bears are there?"));
        tasks.put("UKGLAKELVINGROVE009", new Task.QuestionTask("Answer question #9", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "12,36,6,22".split(","),
                3,"How many galleries are there?"));
        tasks.put("UKGLAKELVINGROVE010", new Task.QuestionTask("Answer question #10", Task.TaskType.QUESTION, "UKGLAKELVINGROVE", "Alasdair Gray,James Docharty,David Simmons,Sydney Elmer Schofield".split(","),
                1,"Who painted \"Head of the Holy Loch\""));
        tasks.put("UKGLAHILLHEADSUB001", new Task.QuestionTask("Answer question #1", Task.TaskType.QUESTION, "UKGLAHILLHEADSUB", "Sir Roger,Sir David,Sir Remmy,Sir Ballantyne".split(","),
                0,"What is the name of the large elephant housed here?"));
        tasks.put("UKGLAHILLHEADSUB002", new Task.QuestionTask("Answer question #2", Task.TaskType.QUESTION, "UKGLAHILLHEADSUB", "£3,£4.50,£2.75,£1.80".split(","),
                0,"How much is a return ticket?"));
        tasks.put("UKGLAHILLHEADSUB003", new Task.QuestionTask("Answer question #3", Task.TaskType.QUESTION, "UKGLAHILLHEADSUB", "1900,1856,1914,1896".split(","),
                3,"When did the subway open?"));
        tasks.put("UKGLAHILLHEADSUB004", new Task.QuestionTask("Answer question #4", Task.TaskType.QUESTION, "UKGLAHILLHEADSUB", "3,4,1,3".split(","),
                2,"How many stops away is Kelvinbridge Station?"));
        tasks.put("UKGLAHILLHEADSUB005", new Task.QuestionTask("Answer question #5", Task.TaskType.QUESTION, "UKGLAHILLHEADSUB", "The Shoogle,The Woogie,The Clickity,The Back and Forth".split(","),
                0,"What do locals call the shaking of the subway carriages?"));
        tasks.put("UKGLAKELVINGROVE011", new Task("Take a selfie inside the museum", Task.TaskType.PHOTO, "UKGLAHILLHEADSUB"));
    }
    public static MockDatabase getInstance() {
        if(instance == null) {
            instance = new MockDatabase();
        }
        return instance;
    }

    public static void setInstance(MockDatabase instance) {
        MockDatabase.instance = instance;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public HashMap<String, City> getCities() {
        return cities;
    }

    public void setCities(HashMap<String, City> cities) {
        this.cities = cities;
    }

    public HashMap<String, Landmark> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(HashMap<String, Landmark> landmarks) {
        this.landmarks = landmarks;
    }

    public HashMap<String, Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(HashMap<String, Achievement> achievements) {
        this.achievements = achievements;
    }

    public HashMap<String, Adventure> getAdventures() {
        return adventures;
    }

    public void setAdventures(HashMap<String, Adventure> adventures) {
        this.adventures = adventures;
    }

    public HashMap<String, Task> getTasks() {
        return tasks;
    }

    public void setTasks(HashMap<String, Task> tasks) {
        this.tasks = tasks;
    }
}
