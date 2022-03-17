package com.empereur.security.Repository;

import com.empereur.security.Models.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VisitRepository extends JpaRepository<Visite, Long> {
}
