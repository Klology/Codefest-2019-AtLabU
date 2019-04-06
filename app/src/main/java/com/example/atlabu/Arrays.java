package com.example.atlabu;

import java.util.ArrayList;

public class Arrays {


    public String username;

    /**
     * Exercise menu item array
     * @return exerciseList
     */

    public static ArrayList<String> getExercise(){
    ArrayList<String> exerciseList = new ArrayList<>();
    exerciseList.add("Sit-Ups- Perform as many push-ups as you can.");
    exerciseList.add("Perform as many sit-ups as you can.");
    exerciseList.add("Perform as many squats as you can.");
    exerciseList.add("Perform a one minute plank.");
        return exerciseList;
    }

    public static ArrayList<String> getBrain(){
        ArrayList<String> brainList = new ArrayList<>();
        brainList.add("Solve a math problem.");
        brainList.add("Match a vocabulary definition.");
        return brainList;
    }

    public static ArrayList<String> getHealth(){
        ArrayList<String> healthList = new ArrayList<>();
        healthList.add("Drink a glass of water.");
        healthList.add("Go to bed on time.");
        return healthList;
    }


    //mutator to accept single string username
    public void setUsername (String username){
        this.username = username;
    }
}
