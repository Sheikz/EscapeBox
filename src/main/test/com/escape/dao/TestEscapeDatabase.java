package com.escape.dao;

import com.escape.model.Room;
import com.escape.model.Run;
import com.escape.model.Scenario;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * Created by Sheikz on 8/17/2016.
 */
public class TestEscapeDatabase
{
    /*
    @Test
    public void TestCreateScenario()
    {
        Stack<Integer> idCreated = new Stack();
        Stack<Scenario> scenariosCreated = new Stack();
        List<Scenario> result = ScenarioDAO.getScenarios();

        Assert.assertEquals(0, result.size());

        scenariosCreated.add(new Scenario("RoomTest135", 5, 60));
        scenariosCreated.add(new Scenario("toto", 10, 20));
        scenariosCreated.add(new Scenario("baba", 7, 10));
        scenariosCreated.add(new Scenario("ojhoi87", 1, 300));

        for (Scenario s : scenariosCreated)
        {
            idCreated.add(ScenarioDAO.addScenario(s));
        }

        result = ScenarioDAO.getScenarios();
        Assert.assertEquals(4, result.size());

        Assert.assertEquals("RoomTest135", result.get(0).getName());
        Assert.assertEquals(5, result.get(0).getNumberOfPlayers());

        for (int id : idCreated)
        {
            ScenarioDAO.deleteScenario(id);
        }

        result = ScenarioDAO.getScenarios();
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testCreateRun()
    {
        Scenario scenario = new Scenario("testScenario", 5, 60);
        Room room = new Room("Room 1");
        room.setScenario(scenario);
        Run r = new Run(room);

        int id = RunDAO.addRun(r);
        Run r2 = RunDAO.getRun(id);
        List<Run> result = RunDAO.getRuns();

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(scenario.getId(), r2.getRoom().getScenario().getId());
        Assert.assertEquals(scenario.getName(), r2.getRoom().getScenario().getName());
        Assert.assertEquals(scenario.getNumberOfPlayers(), r2.getRoom().getScenario().getNumberOfPlayers());
    }*/
}
