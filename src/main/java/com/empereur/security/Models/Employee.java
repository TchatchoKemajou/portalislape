package com.empereur.security.Models;

import javax.persistence.*;



@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empID;

    private Long empMatricule;

    private String empFullName;

    public Employee() {
    }

    public Employee(Long empID, Long empMatricule, String empFullName) {
        this.empID = empID;
        this.empMatricule = empMatricule;
        this.empFullName = empFullName;
    }

    public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    public Long getEmpMatricule() {
        return empMatricule;
    }

    public void setEmpMatricule(Long empMatricule) {
        this.empMatricule = empMatricule;
    }

    public String getEmpFullName() {
        return empFullName;
    }

    public void setEmpFullName(String empFullName) {
        this.empFullName = empFullName;
    }
}
