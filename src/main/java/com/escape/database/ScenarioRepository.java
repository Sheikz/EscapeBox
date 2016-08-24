package com.escape.database;

import com.escape.model.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sheikz on 8/24/2016.
 */
public interface ScenarioRepository extends JpaRepository<Scenario, Integer>{
}
