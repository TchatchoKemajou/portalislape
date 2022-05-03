package com.empereur.security.RestController;

import com.empereur.security.Services.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/scan")
public class CarteRestController {

    @Autowired
    private CarteService carteService;

    @GetMapping("/scancarte/{code}")
    public boolean scanCarte(@PathVariable String code){
        return carteService.ScanAndVerifyCarte(code);
    }
}
