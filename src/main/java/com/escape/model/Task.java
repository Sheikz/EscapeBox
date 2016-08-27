package com.escape.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Sheikz on 8/27/2016.
 */
@Entity
public class Task implements Serializable{
    @Id
    @GeneratedValue
    private int id;

    private String name;

    // In minutes
    private int expectedTimeToFinish;

    public Task(){}

    public Task(String name, int expectedTimeToFinish) {
        this.name = name;
        this.expectedTimeToFinish = expectedTimeToFinish;
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

    public int getExpectedTimeToFinish() {
        return expectedTimeToFinish;
    }

    public void setExpectedTimeToFinish(int expectedTimeToFinish) {
        this.expectedTimeToFinish = expectedTimeToFinish;
    }
}
