package com.escape.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;

/**
 * Created by Sheikz on 8/17/2016.
 */
@Entity
public class Run implements Serializable
{
    @Id
    @GeneratedValue
    private int id;
    private Instant startTime;
    private Scenario scenario;

    public Run(){};

    public Run(Scenario scenario)
    {
        this.startTime = Instant.now();
        this.scenario = scenario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
