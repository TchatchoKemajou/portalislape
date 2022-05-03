package com.empereur.security.Repository;

import com.empereur.security.Models.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {

    RoleUser findRoleUserByRoleName(String roleName);
}
