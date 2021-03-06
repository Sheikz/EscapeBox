package com.escape.service;

import com.escape.exception.RoomNotFound;
import com.escape.exception.RunForbiddenAction;
import com.escape.exception.RunNotFound;
import com.escape.exception.ScenarioNotDefined;
import com.escape.model.Run;

import java.util.List;

/**
 * Created by Sheikz on 8/26/2016.
 */
public interface RunService {

    List<Run> findAll();

    Run findById(int id) throws RunNotFound;

    Run create(Run run);

    Run start(int roomId) throws RoomNotFound, ScenarioNotDefined, RunNotFound, RunForbiddenAction;

    Run pause(int runId) throws RunNotFound, RunForbiddenAction;

    Run resume(int runId) throws RunForbiddenAction, RunNotFound;

    void close(int runId) throws RunNotFound;

    void delete(int id) throws RunNotFound;

    Run update(Run r) throws RunNotFound;
}
