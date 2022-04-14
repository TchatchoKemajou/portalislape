package com.empereur.security.Services;

import com.empereur.security.DTO.VisiteDTO;
import com.empereur.security.Models.Visite;
import com.empereur.security.Repository.VisitRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VisitServices {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private  VisitorService visitorService;

    @Autowired
    private  GuardServices guardServices;

    @Autowired
    private  SiteSevices siteSevices;

    public List<Visite> allVisits(){
        return  visitRepository.findAll();
    }

    public  Visite saveVisit(VisiteDTO visitedto){
        Visite visite = new Visite();
        BeanUtils.copyProperties(visitedto, visite);
        visite.setGuardID(guardServices.guardById(visitedto.getGuardID()));
        visite.setVisitorId(visitorService.visiteurById(visitedto.getVisitorId()));
        visite.setVisitSite(siteSevices.siteById(visitedto.getVisitSite()));
        visite.setVisitDate(new java.sql.Date(new Date().getTime()));
        visite.setVisitTimeStar(String.valueOf(new java.sql.Time(new Date().getTime())));
        return  visitRepository.save(visite);
    }

    public Visite findVisitByCarteTemp(String temporalcarte){
        List<Visite> visitList = visitRepository.findAll();

        for(Visite visite:visitList){
            if (visite.getVisitCarteTemp().equals(temporalcarte)){
                return  visite;
            }
        }
        return  null;
    }

    public List<Visite> allVisite(){return  visitRepository.findAll();}

//    public List<Visite> allVisitToDay(){
//        return visitRepository.findAllByDate(new java.sql.Date(new Date().getTime()));
//    }


    public  List<Visite> allVisitorDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Visite> visiteurList = visitRepository.findAll();
        List<Visite> visitesDay = new ArrayList<>();

        for (Visite visite:visiteurList){
            //System.out.printf(sdf.format(visite.getVisitDate()));
            System.out.printf(String.valueOf(LocalDate.now()));
            if (sdf.format(visite.getVisitDate()).equals((LocalDate.now()).toString())){
                visitesDay.add(visite);
            }
        }
        System.out.printf(String.valueOf(visitesDay.size()));
        return  visitesDay;
    }
}
