package com.escape.controller;

import com.escape.database.ScenarioDAO;
import com.escape.model.Scenario;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sheikz on 8/17/2016.
 */
@RestController
@RequestMapping("/api/scenario/")
public class APIScenarioController
{
    private static Logger logger = Logger.getLogger(APIScenarioController.class);

    @RequestMapping(value="list", method = RequestMethod.GET)
    public @ResponseBody List<Scenario> getScenarios()
    {
        return ScenarioDAO.getScenarios();
    }

    @ResponseBody
    @RequestMapping(value="create", method = RequestMethod.POST)
    public void createScenario(@RequestBody Scenario scenario)
    {
    	ScenarioDAO.addScenario(scenario);
    }

    @ResponseBody
    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public void deleteScenario(@PathVariable int id)
    {
        ScenarioDAO.deleteScenario(id);
    }

}
