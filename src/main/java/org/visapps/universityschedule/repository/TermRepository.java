package org.visapps.universityschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visapps.universityschedule.entity.Term;

public interface TermRepository extends JpaRepository<Term, Integer> {
}
