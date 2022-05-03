package com.empereur.security.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
public class Gardien implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long guardId;

    private Date guardCreateDate;

    private  String guardFullName;

    private  String guardUserName;

    private  String guardIsActif;

    private String guardPassword;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  RoleUser role;

    @OneToMany(targetEntity = Visite.class, cascade = CascadeType.ALL)
    private List<Visite> visites;

    public Gardien() {
    }

    public Gardien(Long guardId, Date guardCreateDate, String guardFullName, String guardUserName,
                   String guardIsActif, String guardPassword, RoleUser role) {
        this.guardId = guardId;
        this.guardCreateDate = guardCreateDate;
        this.guardFullName = guardFullName;
        this.guardUserName = guardUserName;
        this.guardIsActif = guardIsActif;
        this.guardPassword = guardPassword;
        this.role = role;
    }

    public RoleUser getRole() {
        return role;
    }

    public void setRole(RoleUser role) {
        this.role = role;
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

    public String getGuardUserName() {
        return guardUserName;
    }

    public void setGuardUserName(String guardUserName) {
        this.guardUserName = guardUserName;
    }

    public String getGuardPassword() {
        return guardPassword;
    }

    public void setGuardPassword(String guardPassword) {
        this.guardPassword = guardPassword;
    }

    public String getGuardIsActif() {
        return guardIsActif;
    }

    public void setGuardIsActif(String guardIsActif) {
        this.guardIsActif = guardIsActif;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.guardPassword;
    }

    @Override
    public String getUsername() {
        return this.guardUserName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /* spring.datasource.url=jdbc:mysql://localhost:3306/islapeDB1
spring.datasource.username=root
spring.datasource.password=
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.dll-auto = update */
}

