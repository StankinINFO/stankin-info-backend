package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Load;

public interface LoadRepository extends JpaRepository<Load, Integer> {
}
