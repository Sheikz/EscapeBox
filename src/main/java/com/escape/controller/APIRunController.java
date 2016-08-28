package com.escape.controller;

import com.escape.exception.RunForbiddenAction;
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
    Run getRun(@PathVariable int id) throws RunNotFound {
        return runService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Run> getRuns() {
        return runService.findAll();
    }

    @RequestMapping(value="/{id}/pause", method = RequestMethod.POST)
    public
    @ResponseBody
    void pauseRun(@PathVariable int id) throws RunForbiddenAction, RunNotFound {
        runService.pause(id);
    }

    @RequestMapping(value="/{id}/resume", method = RequestMethod.POST)
    public
    @ResponseBody
    void resumeRun(@PathVariable int id) throws RunNotFound, RunForbiddenAction {
        runService.resume(id);
    }

    @RequestMapping(value="/{id}/close", method = RequestMethod.POST)
    public
    @ResponseBody
    void closeRun(@PathVariable int id) throws RunNotFound {
        runService.close(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRun(@PathVariable int id) throws RunNotFound {
        runService.delete(id);
    }
}
