package com.empereur.security.Repository;


import com.empereur.security.Models.Gardien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GuardRepository extends JpaRepository<Gardien, Long> {
    Optional<Gardien> findByguardUserName(String guardUserName);
}
