package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Chair;

public interface ChairRepository extends JpaRepository<Chair, Integer> {
}
