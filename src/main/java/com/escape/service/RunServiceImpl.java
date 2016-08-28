package com.escape.service;

import com.escape.dao.RunRepository;
import com.escape.exception.RoomNotFound;
import com.escape.exception.RunForbiddenAction;
import com.escape.exception.RunNotFound;
import com.escape.exception.ScenarioNotDefined;
import com.escape.model.Room;
import com.escape.model.Run;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

/**
 * Created by Sheikz on 8/26/2016.
 */
@Service
public class RunServiceImpl implements RunService {

    @Resource
    private RunRepository runRepository;

    @Autowired
    private RoomService roomService;

    @Override
    public List<Run> findAll() {
        return runRepository.findAll();
    }

    @Override
    public Run findById(int id) throws RunNotFound {
        Run r = runRepository.findOne(id);
        if (r == null)
            throw new RunNotFound("No run found with id " + id);
        return r;
    }

    @Override
    public Run create(Run run) {
        return runRepository.save(run);
    }

    /**
     * Start a run with a specified roomId
     *
     * @param roomId
     * @return
     * @throws RoomNotFound
     */
    @Override
    public Run start(int roomId) throws RoomNotFound, ScenarioNotDefined, RunNotFound, RunForbiddenAction {
        Room r = roomService.findById(roomId);
        if (r.getScenario() == null)
            throw new ScenarioNotDefined("Room id "+roomId+" cannot be started because it has no scenario defined");

        Run currentRun = runRepository.findOne(r.getRunId());
        if (currentRun != null)
            throw new RunForbiddenAction("A run is active in room "+roomId);
        Run run = new Run(r);
        runRepository.save(run);

        r.setRunId(run.getId());
        roomService.update(r);
        return run;
    }

    @Override
    public Run pause(int runId) throws RunNotFound, RunForbiddenAction {
        Run r = findById(runId);
        if (r.getState() != Run.State.ACTIVE)
            throw new RunForbiddenAction("Run is not active");
        r.setState(Run.State.PAUSED);
        runRepository.save(r);
        return r;
    }

    @Override
    public Run resume(int runId) throws RunForbiddenAction, RunNotFound {
        Run r = findById(runId);
        if (r.getState() != Run.State.PAUSED)
            throw new RunForbiddenAction("Run is not paused");
        r.setState(Run.State.ACTIVE);
        runRepository.save(r);
        return r;
    }

    @Override
    public void close(int runId) throws RunNotFound {
        Run r = findById(runId);
        r.setState(Run.State.FINISHED);
        r.setEndTime(Instant.now());
        runRepository.save(r);
    }

    @Override
    public void delete(int id) throws RunNotFound {
        Run r = findById(id);
        runRepository.delete(r);
    }

    @Override
    public Run update(Run r) throws RunNotFound {
        Run existing = findById(r.getId());
        runRepository.save(r);
        return r;
    }
}
