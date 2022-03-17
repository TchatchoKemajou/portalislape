package com.empereur.security.Services;

import com.empereur.security.Models.Visiteur;
import com.empereur.security.Repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    public Visiteur CreateVisitor(Visiteur visiteur){
        return  visitorRepository.save(visiteur);
    }

    public List<Visiteur> readVisitors(){
        return  visitorRepository.findAll();
    }

    public Visiteur visiteurById(Long id){return  visitorRepository.getById(id);}

}
