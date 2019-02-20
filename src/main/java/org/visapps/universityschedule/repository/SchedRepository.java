package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Sched;

public interface SchedRepository extends JpaRepository<Sched, Integer> {
}
