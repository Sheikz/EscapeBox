package com.escape.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheikz on 8/15/2016.
 */
@Entity
public class Scenario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int numberOfPlayers;
    private ArrayList<Task> tasks;

    // Duration in minutes
    private int duration;

    public Scenario() {
        tasks = new ArrayList<>();
    }

    public Scenario(String name, int numberOfPlayers, int duration) {
        this.tasks = new ArrayList<>();
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
