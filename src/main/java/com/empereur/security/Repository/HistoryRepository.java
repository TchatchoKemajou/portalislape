package com.empereur.security.Repository;

import com.empereur.security.Models.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HistoryRepository extends JpaRepository<Historique, Long> {

}
