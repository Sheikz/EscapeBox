package com.escape.controller;

import com.escape.database.ScenarioDAO;
import com.escape.database.ScenarioRepository;
import com.escape.model.Scenario;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sheikz on 8/17/2016.
 */
@RestController
@RequestMapping("/api/scenarios")
public class APIScenarioController
{
    private static Logger logger = Logger.getLogger(APIScenarioController.class);

    @Resource
    private ScenarioRepository scenarioRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Scenario> getScenarios()
    {
        return scenarioRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Scenario getScenario(@PathVariable int id)
    {
        return scenarioRepository.findOne(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void createScenario(@RequestBody Scenario scenario)
    {
    	scenarioRepository.save(scenario);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteScenario(@PathVariable int id)
    {
        scenarioRepository.delete(id);
    }

}
