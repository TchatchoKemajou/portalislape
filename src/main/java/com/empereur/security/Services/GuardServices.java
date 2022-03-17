package com.empereur.security.Services;

import com.empereur.security.Models.Gardien;
import com.empereur.security.Repository.GuardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardServices {

    @Autowired
    private GuardRepository guardRepository;

    public Gardien CreateGuard(Gardien gardien){
        return guardRepository.save(gardien);
    }

    public Gardien guardById(Long id){return guardRepository.getById(id);}
}
