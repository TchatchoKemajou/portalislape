package com.empereur.security.Repository;

import com.empereur.security.Models.Trafic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraficRepository extends JpaRepository<Trafic, Long> {

}
