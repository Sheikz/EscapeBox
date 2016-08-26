package com.escape.service;

import com.escape.exception.RoomNotFound;
import com.escape.exception.ScenarioNotFound;
import com.escape.model.Room;

import java.util.List;

/**
 * Created by Sheikz on 8/26/2016.
 */
public interface RoomService {

    List<Room> findAll();

    Room findById(int id) throws RoomNotFound;

    Room create(Room r);

    void delete(int id) throws RoomNotFound;

    Room update(Room r) throws RoomNotFound;

    void associate(int roomId, int scenarioId) throws RoomNotFound, ScenarioNotFound;
}
