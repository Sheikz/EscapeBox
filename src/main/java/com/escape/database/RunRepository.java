package com.escape.database;

import com.escape.model.Run;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sheikz on 8/24/2016.
 */
public interface RunRepository extends JpaRepository<Run, Integer>{
}
