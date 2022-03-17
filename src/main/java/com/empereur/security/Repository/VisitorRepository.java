package com.empereur.security.Repository;

import com.empereur.security.Models.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VisitorRepository extends JpaRepository<Visiteur, Long> {
}
