package com.empereur.security.RestController;

import com.empereur.security.Models.Etudiant;
import com.empereur.security.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etudiant")
public class EtudiantRestController {
    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("/allstudent")
    public List<Etudiant> allStudent(){
        return etudiantService.findAllEtudiant();
    }

    @PostMapping("/saveetudiant")
    public void saveEtudiant(@RequestBody Etudiant etudiant){
        etudiantService.saveEtudiant(etudiant);
    }

    @PutMapping("/desactivateetudiant/{id}")
    public Etudiant desactivateEtudiant(@PathVariable Long id){
        return etudiantService.desactivateStudent(id);
    }
}
