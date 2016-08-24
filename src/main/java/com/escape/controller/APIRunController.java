package com.escape.controller;

import com.escape.database.*;
import com.escape.model.Room;
import com.escape.model.Run;
import com.escape.model.Scenario;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


/**
 * Created by Sheikz on 8/17/2016.
 */
@RestController
@RequestMapping("/api/runs")
public class APIRunController {

    private static final Logger logger = Logger.getLogger(APIRunController.class);

    @Resource
    private RunRepository runRepository;

    @Resource
    private RoomRepository roomRepository;

    @ResponseBody
    @RequestMapping(value="/start/{roomId}", method = RequestMethod.POST)
    public void startRun(@PathVariable int roomId)
    {
        Room r = roomRepository.findOne(roomId);
        if (r == null)
            return;

        Run run = new Run(r);
        runRepository.save(run);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Run getRoom(@PathVariable int id)
    {
        return runRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Run> getRooms()
    {
        return runRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable int id)
    {
        runRepository.delete(id);
    }
}
