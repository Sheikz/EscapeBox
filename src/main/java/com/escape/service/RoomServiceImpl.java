package com.escape.service;

import com.escape.dao.RoomRepository;
import com.escape.exception.RoomNotFound;
import com.escape.exception.ScenarioNotFound;
import com.escape.model.Room;
import com.escape.model.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sheikz on 8/26/2016.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Resource
    RoomRepository roomRepository;

    @Autowired
    ScenarioService scenarioService;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(int id) throws RoomNotFound {
        Room r = roomRepository.findOne(id);
        if (r == null)
            throw new RoomNotFound("No room found with id " + id);
        return r;
    }

    @Override
    public Room create(Room r) {
        roomRepository.save(r);
        return r;
    }

    @Override
    public void delete(int id) throws RoomNotFound {
        Room r = findById(id);
        roomRepository.delete(r);
    }

    @Override
    public Room update(Room r) throws RoomNotFound {
        Room a = findById(r.getId());
        roomRepository.save(r);
        return r;
    }

    /**
     * Associate a room with a scenario
     *
     * @param roomId
     * @param scenarioId
     * @throws RoomNotFound
     * @throws ScenarioNotFound
     */
    @Override
    public void associate(int roomId, int scenarioId) throws RoomNotFound, ScenarioNotFound {
        Room r = findById(roomId);
        Scenario s = scenarioService.findById(scenarioId);
        r.setScenario(s);
        roomRepository.save(r);
    }
}
