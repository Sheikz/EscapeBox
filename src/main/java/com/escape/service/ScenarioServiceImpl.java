package com.escape.service;

import com.escape.dao.ScenarioRepository;
import com.escape.exception.ScenarioNotFound;
import com.escape.model.Scenario;
import com.escape.model.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sheikz on 8/26/2016.
 */
@Service
public class ScenarioServiceImpl implements ScenarioService {

    @Resource
    private ScenarioRepository scenarioRepository;

    @Override
    public List<Scenario> findAll() {
        return scenarioRepository.findAll();
    }

    @Override
    public Scenario findById(int id) throws ScenarioNotFound {
        Scenario s = scenarioRepository.findOne(id);
        if (s == null)
            throw new ScenarioNotFound("No scenario found with id " + id);
        return s;
    }

    @Override
    public Scenario create(Scenario s) {
        scenarioRepository.save(s);
        return s;
    }

    @Override
    public void delete(int id) throws ScenarioNotFound {
        Scenario existing = findById(id);
        scenarioRepository.delete(existing);
    }

    @Override
    public Scenario update(Scenario s) throws ScenarioNotFound {
        Scenario existing = findById(s.getId());
        scenarioRepository.save(s);
        return s;
    }

    @Override
    public void addTask(int id, Task t) throws ScenarioNotFound {
        Scenario s = findById(id);
        s.getTasks().add(t);
        update(s);
    }
}
