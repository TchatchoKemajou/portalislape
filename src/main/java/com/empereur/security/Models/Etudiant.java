package com.empereur.security.Models;

import javax.persistence.*;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long etuID;

    private  String etuMatricule;

    private  String etuCode;

    private  String etuFullName;

    private  String specialite;

    private String niveau;

    public Etudiant() {
    }

    public Etudiant(Long etuID, String etuMatricule, String etuCode, String etuFullName, String specialite, String niveau) {
        this.etuID = etuID;
        this.etuMatricule = etuMatricule;
        this.etuCode = etuCode;
        this.etuFullName = etuFullName;
        this.specialite = specialite;
        this.niveau = niveau;
    }

    public Long getEtuID() {
        return etuID;
    }

    public void setEtuID(Long etuID) {
        this.etuID = etuID;
    }

    public String getEtuMatricule() {
        return etuMatricule;
    }

    public void setEtuMatricule(String etuMatricule) {
        this.etuMatricule = etuMatricule;
    }

    public String getEtuCode() {
        return etuCode;
    }

    public void setEtuCode(String etuCode) {
        this.etuCode = etuCode;
    }

    public String getEtuFullName() {
        return etuFullName;
    }

    public void setEtuFullName(String etuFullName) {
        this.etuFullName = etuFullName;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
