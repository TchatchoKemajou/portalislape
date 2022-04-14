package com.empereur.security.Repository;

import com.empereur.security.Models.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface VisitRepository extends JpaRepository<Visite, Long> {
    @Query(value = "select v from Visite v where  CAST(v.visitDate as date) = CAST(:day as date)",nativeQuery = true)
    List<Visite> findAllByDate(Date day);
}
