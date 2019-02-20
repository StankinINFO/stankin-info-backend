package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
