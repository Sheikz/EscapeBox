package com.escape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * Created by Sheikz on 7/31/2016.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    private static Logger logger = Logger.getLogger("HomeController");

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {

        return "index";
    }
}
