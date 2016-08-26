package com.escape.controller;

import com.escape.exception.RunNotFound;
import com.escape.model.Run;
import com.escape.service.RunService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Sheikz on 8/17/2016.
 */
@RestController
@RequestMapping("/api/runs")
public class APIRunController {

    private static final Logger logger = Logger.getLogger(APIRunController.class);

    @Autowired
    RunService runService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Run getRoom(@PathVariable int id) throws RunNotFound {
        return runService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Run> getRooms() {
        return runService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable int id) throws RunNotFound {
        runService.delete(id);
    }
}
