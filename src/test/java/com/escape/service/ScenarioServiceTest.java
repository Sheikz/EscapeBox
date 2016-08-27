package com.escape.service;

import com.escape.config.EscapeBoxConfig;
import com.escape.config.PersistenceConfig;
import com.escape.exception.ScenarioNotFound;
import com.escape.model.Scenario;
import com.escape.model.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Sheikz on 8/27/2016.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EscapeBoxConfig.class, PersistenceConfig.class})
public class ScenarioServiceTest {

    @Autowired
    ScenarioService scenarioService;

    @Test
    public void addTaskTest() throws ScenarioNotFound {

        Task t1 = new Task("Task 1", 60);
        Task t2 = new Task("Task 2", 30);

        Scenario s1 = new Scenario();
        scenarioService.create(s1);

        scenarioService.addTask(s1.getId(), t1);
        scenarioService.addTask(s1.getId(), t2);

        Scenario s2 = scenarioService.findById(s1.getId());

        Assert.assertEquals(s2.getTasks().get(0).getName(), t1.getName());
        Assert.assertEquals(s2.getTasks().get(0).getExpectedTimeToFinish(), t1.getExpectedTimeToFinish());
        Assert.assertEquals(s2.getTasks().get(1).getName(), t2.getName());
        Assert.assertEquals(s2.getTasks().get(1).getExpectedTimeToFinish(), t2.getExpectedTimeToFinish());
    }
}
