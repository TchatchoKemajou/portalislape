package com.empereur.security.RestController;

import com.empereur.security.Models.Etudiant;
import com.empereur.security.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/etudiant")
public class EtudiantRestController {
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/saveetudiant")
    public void saveEtudiant(@RequestBody Etudiant etudiant){
        etudiantService.saveEtudiant(etudiant);
    }

    @PutMapping("/desactivateetudiant/{id}")
    public void desactivateEtudiant(@PathVariable Long id){
        etudiantService.desactivateStudent(id);
    }
}
