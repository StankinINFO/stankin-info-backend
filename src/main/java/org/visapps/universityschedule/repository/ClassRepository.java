package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Class;

public interface ClassRepository extends JpaRepository<Class, Integer> {
}
