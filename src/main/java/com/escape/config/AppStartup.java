package com.escape.config;

import com.escape.exception.RoomNotFound;
import com.escape.exception.ScenarioNotFound;
import com.escape.model.Room;
import com.escape.model.Scenario;
import com.escape.service.RoomService;
import com.escape.service.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

/**
 * Created by Sheikz on 8/29/2016.
 */
@Component
public class AppStartup {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ScenarioService scenarioService;

    /**
     * Initial load
     * @throws RoomNotFound
     * @throws ScenarioNotFound
     */
    @PostConstruct
    public void startup() throws RoomNotFound, ScenarioNotFound {
        Scenario s1 = new Scenario("Sherlock", 4, 60);
        Scenario s2 = new Scenario("Maya", 6, 60);

        scenarioService.create(s1);
        scenarioService.create(s2);

        Room r1 = new Room("Room 1");
        Room r2 = new Room("Room 2");
        Room r3 = new Room("Room 3");

        roomService.create(r1);
        roomService.create(r2);
        roomService.create(r3);

        roomService.associate(r1.getId(), s1.getId());
        roomService.associate(r2.getId(), s2.getId());
    }

}
