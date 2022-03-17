package com.empereur.security.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Gardien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long guardId;

    private Date guardCreateDate;

    private  String guardFullName;

    private  String guardLastName;

    private  String guardIsActif;

    @OneToMany(targetEntity = Visite.class, cascade = CascadeType.ALL)
    private List<Visite> visites;

    public Gardien() {
    }

    public Gardien(Long guardId, Date guardCreateDate, String guardFullName, String guardLastName, String guardIsActif) {
        this.guardId = guardId;
        this.guardCreateDate = guardCreateDate;
        this.guardFullName = guardFullName;
        this.guardLastName = guardLastName;
        this.guardIsActif = guardIsActif;
    }

    public Long getGuardId() {
        return guardId;
    }

    public void setGuardId(Long guardId) {
        this.guardId = guardId;
    }

    public Date getGuardCreateDate() {
        return guardCreateDate;
    }

    public void setGuardCreateDate(Date guardCreateDate) {
        this.guardCreateDate = guardCreateDate;
    }

    public String getGuardFullName() {
        return guardFullName;
    }

    public void setGuardFullName(String guardFullName) {
        this.guardFullName = guardFullName;
    }

    public String getGuardLastName() {
        return guardLastName;
    }

    public void setGuardLastName(String guardLastName) {
        this.guardLastName = guardLastName;
    }

    public String getGuardIsActif() {
        return guardIsActif;
    }

    public void setGuardIsActif(String guardIsActif) {
        this.guardIsActif = guardIsActif;
    }

    /* spring.datasource.url=jdbc:mysql://localhost:3306/islapeDB1
spring.datasource.username=root
spring.datasource.password=
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.dll-auto = update */
}

