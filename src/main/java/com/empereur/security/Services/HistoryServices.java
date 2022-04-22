package com.empereur.security.Services;


import com.empereur.security.Models.Historique;
import com.empereur.security.Repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoryServices {

    @Autowired
    private HistoryRepository historyRepository;

    public Historique saveHistory(Historique historique){
        historique.setHistDate(new java.sql.Date(new Date().getTime()));
        return  historyRepository.save(historique);
    }

    public  List<Historique> findAllHistorique(){return  historyRepository.findAll();}
}
