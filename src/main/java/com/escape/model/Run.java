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
    public enum State{
        ACTIVE, PAUSED, FINISHED
    };

    @Id
    @GeneratedValue
    private int id;
    private Instant startTime;
    private Instant endTime;
    private Room room;
    private String hint;
    private State state;

    public Run(){
        state = state.ACTIVE;
    };

    public Run(Room room)
    {
        this.startTime = Instant.now();
        this.room = room;
        state = State.ACTIVE;
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

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
