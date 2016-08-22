package com.escape.controller;

import com.escape.database.RoomDAO;
import com.escape.database.ScenarioDAO;
import com.escape.model.Room;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sheikz on 8/20/2016.
 */
@RestController
@RequestMapping("/api/room/")
public class APIRoomController
{
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody Room getRoom(@PathVariable int id)
    {
        return RoomDAO.getRoom(id);
    }

    @RequestMapping(value="associate/{roomId}/{scenarioId}", method = RequestMethod.PATCH)
    public void associateRoom(@PathVariable int roomId, @PathVariable int scenarioId)
    {
        RoomDAO.getRoom(roomId).setScenario(ScenarioDAO.getScenario(scenarioId));
    }

    @ResponseBody
    @RequestMapping(value="create", method = RequestMethod.POST)
    public void addRoom(@RequestBody Room room)
    {
        RoomDAO.addRoom(room);
    }

    @RequestMapping(value="list", method = RequestMethod.GET)
    public @ResponseBody List<Room> getRooms()
    {
        return RoomDAO.getRooms();
    }

    @ResponseBody
    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable int id)
    {
        RoomDAO.deleteRoom(id);
    }

}
