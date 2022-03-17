package com.empereur.security.Services;

import com.empereur.security.Models.Sites;
import com.empereur.security.Repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SiteSevices {

    @Autowired
    private SiteRepository siteRepository;

    public Sites CreateSite(Sites site){
        site.setSiteCreateDate(String.valueOf(new java.sql.Date(new Date().getTime())));
        return siteRepository.save(site);
    }

    public Sites siteById(Long id){return siteRepository.getById(id);}
}
