package com.example.atlabu;

import java.util.ArrayList;

public class Arrays {


    public String username;
    private boolean SUs=false, PUs=false, Ss=false, Ps=false;
    private boolean Ws=false, SLEs=false;

    /**
     * Exercise menu item array
     * @return exerciseList
     */

    public static ArrayList<String> getExercise(){
    ArrayList<String> exerciseList = new ArrayList<>();
    exerciseList.add("Sit-Ups- Perform as many push-ups as you can in 1 Minute.");
    exerciseList.add("Perform as many sit-ups as you can in 1 Minute.");
    exerciseList.add("Perform as many squats as you can in 1 Minute.");
    exerciseList.add("Perform as much of a one minute plank as you can.");
    exerciseList.add("Free Style Exercise!!!!");

        return exerciseList;
    }

    public static ArrayList<String> getBrain(){
        ArrayList<String> brainList = new ArrayList<>();
        brainList.add("Read This:\n" +
                "In a perfect world, you’d be able to make decisions on your own. However, that’s " +
                "not always possible as you may find yourself in a group that is responsible for making " +
                "decisions for your organization, such as a team or committee. When that happens, it’s " +
                "important to limit the number of people to a realistic and efficient number of decision-makers.");
        brainList.add("Read This:\n" +
                "Almost nothing can make the responsibility of decision-making even more challenging. " +
                "However, if you have the wrong person in one of the integral roles within the decision-making " +
                "process, that could certainly make things more difficult for everyone involved.");
        brainList.add("Read This:\n" +
                "Solving problems and making decisions in a constantly-changing professional environment " +
                "can present a number of challenges. So, when you have individual employees or groups in " +
                "place to face those challenges, you need to make sure they are prepared to do so as much as possible.");
        brainList.add("Read This:\n" +
                "Although this may sound ridiculously simple, following a decision-making checklist when faced with " +
                "a business decision can save you time and increase results. By following this checklist (and not " +
                "simply understanding the list items), you can work to counteract a range of cognitive biases and" +
                " mental shortcuts that can hinder our decision-making processes.");
        brainList.add("Read This:\n" +
                "When things are looking up and everything is going well, it’s easy to become complacent " +
                "or to overlook potential concerns with the expectation that everything will remain stable " +
                "and that no calamities will arise. This is when it’s most important to instill a culture " +
                "of humility within your organization and to encourage decision-makers to review the history " +
                "of their organization and industry.");
        //brainList.add("Solve a math problem.");
        //brainList.add("Match a vocabulary definition.");
        return brainList;
    }

    public static ArrayList<String> getHealth(){
        ArrayList<String> healthList = new ArrayList<>();
        healthList.add("Did you Drink Enough Today?");
        healthList.add("Did You Get Enough Sleep?");
        healthList.add("Were you successful today?");
        return healthList;
    }

    public static void SetPUs(boolean PUs){

    }
    //mutator to accept single string username
    public void setUsername (String username){
        this.username = username;
    }
    public void setSUs(Boolean SUz){
        SUs = SUz;
    }
    public void setSs(Boolean Sz){
        Ss = Sz;
    }
    public void setPs(Boolean Pz){
        Ps = Pz;
    }
    public void setWs(Boolean Wz){
        Ws = Wz;
    }
    public void setSLEs(Boolean SLEz){
        SLEs = SLEz;
    }
}
