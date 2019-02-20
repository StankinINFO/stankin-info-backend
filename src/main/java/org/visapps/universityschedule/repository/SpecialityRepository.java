package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
}
