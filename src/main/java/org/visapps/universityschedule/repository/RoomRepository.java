package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
