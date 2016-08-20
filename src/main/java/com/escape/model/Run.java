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
    private Room room;

    public Run(){};

    public Run(Room room)
    {
        this.startTime = Instant.now();
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
