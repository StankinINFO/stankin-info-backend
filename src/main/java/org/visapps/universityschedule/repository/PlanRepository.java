package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
