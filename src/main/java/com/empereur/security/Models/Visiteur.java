package com.empereur.security.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Visiteur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long visitorID;

    private  String visitorFullName;

    private String vistorLastName;

    private  String visitorCardId;

    private String visitorNumber;

    @OneToMany(targetEntity = Visite.class, cascade = CascadeType.ALL)
    private List<Visite> visites;

    public Visiteur() {
    }

    public Visiteur(Long visitorID, String visitorFullName, String vistorLastName, String visitorCardId, String visitorNumber) {
        this.visitorID = visitorID;
        this.visitorFullName = visitorFullName;
        this.vistorLastName = vistorLastName;
        this.visitorCardId = visitorCardId;
        this.visitorNumber = visitorNumber;
    }

    public Long getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(Long visitorID) {
        this.visitorID = visitorID;
    }

    public String getVisitorFullName() {
        return visitorFullName;
    }

    public void setVisitorFullName(String visitorFullName) {
        this.visitorFullName = visitorFullName;
    }

    public String getVistorLastName() {
        return vistorLastName;
    }

    public void setVistorLastName(String vistorLastName) {
        this.vistorLastName = vistorLastName;
    }

    public String getVisitorCardId() {
        return visitorCardId;
    }

    public void setVisitorCardId(String visitorCardId) {
        this.visitorCardId = visitorCardId;
    }

    public String getVisitorNumber() {
        return visitorNumber;
    }

    public void setVisitorNumber(String visitorNumber) {
        this.visitorNumber = visitorNumber;
    }
}
