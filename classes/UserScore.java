package com.example.nnelanut.snakeapplication.classes;

/**
 * Created by nnelanut on 11/29/2017.
 */

public class UserScore {

    private String name;
    private int score;

    public UserScore() {
        setName("AAA");
        setScore(0);

    }

    public UserScore(String newName, int newScore) {

        setName(newName);
        setScore(newScore);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
