package com.empereur.security.Services;

import com.empereur.security.Models.Etudiant;
import com.empereur.security.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;


    public  void saveEtudiant(Etudiant etudiant){
        etudiantRepository.save(etudiant);
    }

    public  void desactivateStudent(Long id){
        Etudiant etudiant = etudiantRepository.getById(id);
        Etudiant newetudiant = etudiant;

        newetudiant.setEtatCarte(false);

        etudiantRepository.save(newetudiant);
    }

    public Etudiant findEtudiantByCode(String code){
        List<Etudiant> studentList = etudiantRepository.findAll();

        for (Etudiant etudiant:studentList){
            if (etudiant.getEtuCode().equals(code) && etudiant.isEtatCarte() == true){
                return  etudiant;
            }
        }
        return  null;
    }
}
