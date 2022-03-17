package com.empereur.security.Repository;


import com.empereur.security.Models.Gardien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuardRepository extends JpaRepository<Gardien, Long> {
}
