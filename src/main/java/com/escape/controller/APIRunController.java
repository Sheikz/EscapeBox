package com.escape.controller;

import com.escape.database.EscapeDatabase;
import com.escape.model.Run;
import com.escape.model.Scenario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * Created by Sheikz on 8/17/2016.
 */
@Controller
@RequestMapping("/api/run/")
public class APIRunController {

    private static final Logger logger = Logger.getLogger("APIRunController");

    @ResponseBody
    @RequestMapping(value="start/{id}", method = RequestMethod.PUT)
    public void startRun(@PathVariable int id)
    {
        Scenario s = EscapeDatabase.getScenario(id);
        Run run = new Run(s);
        EscapeDatabase.addRun(run);
    }
}
