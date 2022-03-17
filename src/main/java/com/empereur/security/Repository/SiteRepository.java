package com.empereur.security.Repository;

import com.empereur.security.Models.Sites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SiteRepository extends JpaRepository<Sites, Long> {
}
