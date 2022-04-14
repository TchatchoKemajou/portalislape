package com.empereur.security.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteService {

    @Autowired
    private VisitServices visitServices;

    @Autowired
    private  EmployeeServices employeeServices;

    @Autowired
    private  EtudiantService etudiantService;

    public boolean ScanAndVerifyCarte(String code){
        if(visitServices.findVisitByCarteTemp(code) != null || etudiantService.findEtudiantByCode(code) != null || employeeServices.findEmployeeByCode(code) != null){
            return  true;
        }
        return  false;
    }

}
