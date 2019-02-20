package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
