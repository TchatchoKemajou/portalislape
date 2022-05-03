package com.empereur.security.Services;


import com.empereur.security.Models.Employee;
import com.empereur.security.Models.Etudiant;
import com.empereur.security.Models.Visite;
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

    @Autowired
    private TraficService traficService;

    public boolean ScanAndVerifyCarte(String code){
        if(visitServices.findVisitByCarteTemp(code) != null || etudiantService.findEtudiantByCode(code) != null || employeeServices.findEmployeeByCode(code) != null){
            if (visitServices.findVisitByCarteTemp(code) != null){
                Visite visite = visitServices.findVisitByCarteTemp(code);
                traficService.saveTrafic(visite.getVisitorId().getVisitorID());
            }else if (etudiantService.findEtudiantByCode(code) != null){
                Etudiant etudiant = etudiantService.findEtudiantByCode(code);
                traficService.saveTrafic(etudiant.getEtuID());
            }else {
                Employee employee = employeeServices.findEmployeeByCode(code);
                traficService.saveTrafic(employee.getEmpID());
            }
            return  true;
        }
        return  false;
    }

}
