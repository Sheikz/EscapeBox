package com.escape.controller;

import com.escape.database.EscapeDatabase;
import com.escape.model.Scenario;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sheikz on 8/17/2016.
 */
@Controller
@RequestMapping("/api/scenario/")
public class APIScenarioController
{
    private static Logger logger = Logger.getLogger(APIScenarioController.class);

    @RequestMapping(value="list", method = RequestMethod.GET)
    public @ResponseBody List<Scenario> getRooms()
    {
        return EscapeDatabase.getScenarios();
    }

    @ResponseBody
    @RequestMapping(value="create", method = RequestMethod.POST)
    public void createRoom(@RequestBody Scenario scenario)
    {
    	EscapeDatabase.addScenario(scenario);
        //return JSONReturnObject.simpleResponse(true);
    }

    @ResponseBody
    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable int id)
    {
        EscapeDatabase.deleteScenario(id);
        //return JSONReturnObject.simpleResponse(true);
    }

}
