package com.empereur.security.RestController;

import com.empereur.security.DTO.VisiteDTO;
import com.empereur.security.Models.Visite;
import com.empereur.security.Services.VisitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/visite")
public class VisiteRestController {

    @Autowired
    private VisitServices visitServices;

    @GetMapping("/allvisite")
    public List<Visite> allVisites(){return  visitServices.allVisits();}

    @GetMapping("/allvisiteday")
    public List<Visite> allCustomVisites(){return  visitServices.allVisitorDay();}

    @PostMapping("/addvisite")
    public Visite addVisite(@RequestBody VisiteDTO visiteDTO){
        return visitServices.saveVisit(visiteDTO);
    }
}
