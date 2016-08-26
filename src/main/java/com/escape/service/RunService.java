package com.escape.service;

import com.escape.exception.RoomNotFound;
import com.escape.exception.RunNotFound;
import com.escape.model.Run;

import java.util.List;

/**
 * Created by Sheikz on 8/26/2016.
 */
public interface RunService {

    List<Run> findAll();

    Run findById(int id) throws RunNotFound;

    Run start(int roomId) throws RoomNotFound;

    void delete(int id) throws RunNotFound;

    Run update(Run r) throws RunNotFound;
}
