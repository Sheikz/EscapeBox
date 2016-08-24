package com.escape.database;

import com.escape.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sheikz on 8/24/2016.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
