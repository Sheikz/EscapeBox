package com.escape.service;

import com.escape.config.EscapeBoxConfig;
import com.escape.config.PersistenceConfig;
import com.escape.config.WebAppInitializer;
import com.escape.exception.RoomNotFound;
import com.escape.exception.RunNotFound;
import com.escape.exception.ScenarioNotDefined;
import com.escape.model.Room;
import com.escape.model.Run;
import com.escape.model.Scenario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Sheikz on 8/27/2016.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EscapeBoxConfig.class, PersistenceConfig.class})
public class RunServiceTest {

    @Autowired
    RunService runService;

    @Autowired
    RoomService roomService;

    @Test(expected = RunNotFound.class)
    public void testUpdateNotExistingRun() throws RunNotFound {
        Run r1 = new Run();
        runService.update(r1);
    }

    @Test
    public void updateRun() throws RoomNotFound, RunNotFound {

        Run r1 = new Run();
        runService.create(r1);
        String hint = "This is a hint";
        Assert.assertEquals(r1.getHint(), null);
        r1.setHint(hint);
        runService.update(r1);
        Run r2 = runService.findById(r1.getId());
        Assert.assertEquals(r2.getHint(), hint);
    }

    @Test(expected = ScenarioNotDefined.class)
    public void startRoomWithoutScenario() throws RoomNotFound, ScenarioNotDefined {
        Room r1 = new Room();
        roomService.create(r1);
        runService.start(r1.getId());
    }
}
