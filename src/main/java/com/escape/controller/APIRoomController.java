package com.escape.controller;

import com.escape.exception.RoomNotFound;
import com.escape.exception.ScenarioNotFound;
import com.escape.model.Room;
import com.escape.model.Run;
import com.escape.service.RoomService;
import com.escape.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sheikz on 8/20/2016.
 */
@RestController
@RequestMapping("/api/rooms")
public class APIRoomController {
    @Autowired
    RoomService roomService;

    @Autowired
    RunService runService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Room> getRooms() {
        return roomService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Room getRoom(@PathVariable int id) throws RoomNotFound {
        return roomService.findById(id);
    }

    @RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
    public
    @ResponseBody
    Run startRun(@PathVariable int id) throws RoomNotFound {
        return runService.start(id);
    }

    @RequestMapping(value = "/{roomId}/associate/{scenarioId}", method = RequestMethod.POST)
    public void associateRoom(@PathVariable int roomId, @PathVariable int scenarioId) throws RoomNotFound, ScenarioNotFound {
        roomService.associate(roomId, scenarioId);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void addRoom(@RequestBody Room room) {
        roomService.create(room);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable int id) throws RoomNotFound {
        roomService.delete(id);
    }

}
