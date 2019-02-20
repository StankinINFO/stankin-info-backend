package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Time;

public interface TimeRepository extends JpaRepository<Time, Integer> {
}
