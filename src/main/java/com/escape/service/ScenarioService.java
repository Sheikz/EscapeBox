package com.escape.service;

import com.escape.exception.ScenarioNotFound;
import com.escape.model.Scenario;

import java.util.List;

/**
 * Created by Sheikz on 8/26/2016.
 */
public interface ScenarioService {

    List<Scenario> findAll();

    Scenario findById(int id) throws ScenarioNotFound;

    Scenario create(Scenario r);

    void delete(int id) throws ScenarioNotFound;

    Scenario update(Scenario r) throws ScenarioNotFound;
}
