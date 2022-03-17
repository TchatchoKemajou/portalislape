package com.empereur.security.RestController;


import com.empereur.security.Models.Visiteur;
import com.empereur.security.Services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/visiteur")
public class VisiteurRestController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/allVisitors")
    public List<Visiteur> allVisitors(){
        return  visitorService.readVisitors();
    }


    @PostMapping("/addVisitor")
    public  Visiteur createVisitor(@RequestBody Visiteur visiteur){
        return visitorService.CreateVisitor(visiteur);
    }

}
