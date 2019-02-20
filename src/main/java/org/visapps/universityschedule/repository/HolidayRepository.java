package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
}
