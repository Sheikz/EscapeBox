package com.escape.controller;

import com.escape.database.RoomDAO;
import com.escape.database.RoomRepository;
import com.escape.database.ScenarioDAO;
import com.escape.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sheikz on 8/20/2016.
 */
@RestController
@RequestMapping("/api/rooms")
public class APIRoomController
{
    @Resource
    private RoomRepository roomRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Room> getRooms()
    {
        return roomRepository.findAll();
        //return RoomDAO.getRooms();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Room getRoom(@PathVariable int id)
    {
        return roomRepository.findOne(id);
    }

    @RequestMapping(value="associate/{roomId}/{scenarioId}", method = RequestMethod.PATCH)
    public void associateRoom(@PathVariable int roomId, @PathVariable int scenarioId)
    {
        RoomDAO.getRoom(roomId).setScenario(ScenarioDAO.getScenario(scenarioId));
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void addRoom(@RequestBody Room room)
    {
        RoomDAO.addRoom(room);
    }

    @ResponseBody
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable int id)
    {
        roomRepository.delete(id);
    }

}
