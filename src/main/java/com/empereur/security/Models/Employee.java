package com.empereur.security.Models;

import javax.persistence.*;



@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empID;

    private String empCode;

    private String empMatricule;

    private String empFullName;

    private  boolean etatCarte;

    public Employee() {
    }

    public Employee(Long empID, String empCode, String empMatricule, String empFullName, boolean etatCarte) {
        this.empID = empID;
        this.empCode = empCode;
        this.empMatricule = empMatricule;
        this.empFullName = empFullName;
        this.etatCarte = etatCarte;
    }

    public boolean isEtatCarte() {
        return etatCarte;
    }

    public void setEtatCarte(boolean etatCarte) {
        this.etatCarte = etatCarte;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    public String getEmpMatricule() {
        return empMatricule;
    }

    public void setEmpMatricule(String empMatricule) {
        this.empMatricule = empMatricule;
    }

    public String getEmpFullName() {
        return empFullName;
    }

    public void setEmpFullName(String empFullName) {
        this.empFullName = empFullName;
    }
}
