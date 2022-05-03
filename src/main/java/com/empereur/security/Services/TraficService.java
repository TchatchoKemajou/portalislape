package com.empereur.security.Services;

import com.empereur.security.Models.Trafic;
import com.empereur.security.Repository.TraficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TraficService {
    @Autowired
    private TraficRepository traficRepository;

    public Trafic saveTrafic(Long id){
        Trafic trafic = new Trafic();

        trafic.setPersonId(id);
        trafic.setTraficDay(new java.sql.Date(new Date().getTime()));
        trafic.setTraficTime(String.valueOf(new java.sql.Time(new Date().getTime())));
        return traficRepository.save(trafic);
    }


}
