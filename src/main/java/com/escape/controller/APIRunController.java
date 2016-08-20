package com.escape.controller;

import com.escape.database.RoomDAO;
import com.escape.database.RunDAO;
import com.escape.database.ScenarioDAO;
import com.escape.model.Room;
import com.escape.model.Run;
import com.escape.model.Scenario;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Sheikz on 8/17/2016.
 */
@RestController
@RequestMapping("/api/run/")
public class APIRunController {

    private static final Logger logger = Logger.getLogger(APIRunController.class);

    @ResponseBody
    @RequestMapping(value="start/{roomId}", method = RequestMethod.PUT)
    public void startRun(@PathVariable int roomId)
    {
        Room r = RoomDAO.getRoom(roomId);
        Run run = new Run(r);
        RunDAO.addRun(run);
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody Run getRoom(@PathVariable int id)
    {
        return RunDAO.getRun(id);
    }

    @RequestMapping(value="list", method = RequestMethod.GET)
    public @ResponseBody
    List<Run> getRooms()
    {
        return RunDAO.getRuns();
    }

    @ResponseBody
    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable int id)
    {
        RunDAO.deleteRun(id);
    }
}
