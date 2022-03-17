package com.empereur.security.Models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Sites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long siteId;

    private  String siteNama;

    private  String siteCreateDate;

    private  String siteIsActif;

    @OneToMany(targetEntity = Visite.class, cascade = CascadeType.ALL)
    private List<Visite> visites;

    public Sites() {
    }

    public Sites(Long siteId, String siteNama, String siteCreateDate, String siteIsActif) {
        this.siteId = siteId;
        this.siteNama = siteNama;
        this.siteCreateDate = siteCreateDate;
        this.siteIsActif = siteIsActif;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteNama() {
        return siteNama;
    }

    public void setSiteNama(String siteNama) {
        this.siteNama = siteNama;
    }

    public String getSiteCreateDate() {
        return siteCreateDate;
    }

    public void setSiteCreateDate(String siteCreateDate) {
        this.siteCreateDate = siteCreateDate;
    }

    public String getSiteIsActif() {
        return siteIsActif;
    }

    public void setSiteIsActif(String siteIsActif) {
        this.siteIsActif = siteIsActif;
    }
}

