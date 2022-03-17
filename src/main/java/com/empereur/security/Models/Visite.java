package com.empereur.security.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Visite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long visitId;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  Visiteur visitorId;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  Gardien guardID;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Sites visitSite;

    private Date visitDate;

    private  String visitTimeStar;

    private  String visiTimeEnd;

    private  String visitStatut;

    private  String visitDescription;

    public Visite() {
    }

    public Visite(Long visitId, Visiteur visitorId, Gardien guardID, Sites visitSite, Date visitDate,
                  String visitTimeStar, String visiTimeEnd, String visitStatut, String visitDescription) {
        this.visitId = visitId;
        this.visitorId = visitorId;
        this.guardID = guardID;
        this.visitSite = visitSite;
        this.visitDate = visitDate;
        this.visitTimeStar = visitTimeStar;
        this.visiTimeEnd = visiTimeEnd;
        this.visitStatut = visitStatut;
        this.visitDescription = visitDescription;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Visiteur getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Visiteur visitorId) {
        this.visitorId = visitorId;
    }

    public Gardien getGuardID() {
        return guardID;
    }

    public void setGuardID(Gardien guardID) {
        this.guardID = guardID;
    }

    public Sites getVisitSite() {
        return visitSite;
    }

    public void setVisitSite(Sites visitSite) {
        this.visitSite = visitSite;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTimeStar() {
        return visitTimeStar;
    }

    public void setVisitTimeStar(String visitTimeStar) {
        this.visitTimeStar = visitTimeStar;
    }

    public String getVisiTimeEnd() {
        return visiTimeEnd;
    }

    public void setVisiTimeEnd(String visiTimeEnd) {
        this.visiTimeEnd = visiTimeEnd;
    }

    public String getVisitStatut() {
        return visitStatut;
    }

    public void setVisitStatut(String visitStatut) {
        this.visitStatut = visitStatut;
    }

    public String getVisitDescription() {
        return visitDescription;
    }

    public void setVisitDescription(String visitDescription) {
        this.visitDescription = visitDescription;
    }
}

