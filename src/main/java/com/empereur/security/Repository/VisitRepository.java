package com.empereur.security.Repository;

import com.empereur.security.Models.Sites;
import com.empereur.security.Models.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface VisitRepository extends JpaRepository<Visite, Long> {
    List<Visite> findAllByVisitSite(Sites visitSite);

    List<Visite> findAllByVisitStatut(String visitStatut);
}
