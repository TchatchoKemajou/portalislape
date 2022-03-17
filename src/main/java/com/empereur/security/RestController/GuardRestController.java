package com.empereur.security.RestController;


import com.empereur.security.Models.Gardien;
import com.empereur.security.Services.GuardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/v1/gardien")
public class GuardRestController {

    @Autowired
    private GuardServices guardServices;

    @PostMapping("/addGuard")
    public Gardien addGuard(@RequestBody Gardien gardien){
        gardien.setGuardCreateDate(new java.sql.Date(new Date().getTime()));
        return  guardServices.CreateGuard(gardien);
    }
}
