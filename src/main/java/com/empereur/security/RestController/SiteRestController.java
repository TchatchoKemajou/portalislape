package com.empereur.security.RestController;


import com.empereur.security.Models.Sites;
import com.empereur.security.Services.SiteSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/site")
public class SiteRestController {
    @Autowired
    private SiteSevices siteSevices;

    @PostMapping("/addSite")
    public Sites createSite(@RequestBody Sites sites){
        return  siteSevices.CreateSite(sites);
    }
}
