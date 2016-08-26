package com.escape.controller;

import com.escape.exception.ScenarioNotFound;
import com.escape.model.Scenario;
import com.escape.service.ScenarioService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sheikz on 8/17/2016.
 */
@RestController
@RequestMapping("/api/scenarios")
public class APIScenarioController {
    private static Logger logger = Logger.getLogger(APIScenarioController.class);

    @Autowired
    ScenarioService scenarioService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Scenario> getScenarios() {
        return scenarioService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Scenario getScenario(@PathVariable int id) throws ScenarioNotFound {
        return scenarioService.findById(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void createScenario(@RequestBody Scenario scenario) {
        scenarioService.create(scenario);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteScenario(@PathVariable int id) throws ScenarioNotFound {
        scenarioService.delete(id);
    }

}
