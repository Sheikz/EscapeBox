package com.escape.service;

import com.escape.dao.RunRepository;
import com.escape.exception.RoomNotFound;
import com.escape.exception.RunNotFound;
import com.escape.model.Room;
import com.escape.model.Run;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    /**
     * Start a run with a specified roomId
     *
     * @param roomId
     * @return
     * @throws RoomNotFound
     */
    @Override
    public Run start(int roomId) throws RoomNotFound {
        Room r = roomService.findById(roomId);
        Run run = new Run(r);
        runRepository.save(run);
        return run;
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
