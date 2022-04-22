package com.empereur.security.RestController;

import com.empereur.security.Models.Historique;
import com.empereur.security.Services.HistoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/historique")
public class HistoriqueRestController {
    @Autowired
    private HistoryServices historyServices;

    @PostMapping("/savehistoque")
    public Historique saveHistorique(@RequestBody Historique historique){return historyServices.saveHistory(historique);}


    @GetMapping("/allhistorique")
    public List<Historique> findAllHistory(){return  historyServices.findAllHistorique();}
}
