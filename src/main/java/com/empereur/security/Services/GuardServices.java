package com.empereur.security.Services;

import com.empereur.security.DTO.GuardDTO;
import com.empereur.security.Models.Gardien;
import com.empereur.security.Models.RoleUser;
import com.empereur.security.Repository.GuardRepository;
import com.empereur.security.Repository.RoleUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GuardServices {

    @Autowired
    private GuardRepository guardRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    public Gardien CreateGuard(GuardDTO guardDTO){
        RoleUser roleUser = roleUserRepository.findRoleUserByRoleName(guardDTO.getRole());
        Gardien gardien = new Gardien();
        BeanUtils.copyProperties(guardDTO, gardien);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(guardDTO.getGuardPassword());
        gardien.setGuardPassword(password);
        gardien.setRole(roleUser);
        gardien.setGuardCreateDate(new java.sql.Date(new Date().getTime()));
        return guardRepository.save(gardien);
    }

    public Gardien guardById(Long id){return guardRepository.getById(id);}
}
