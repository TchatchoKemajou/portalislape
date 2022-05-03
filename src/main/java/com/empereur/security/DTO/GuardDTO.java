package com.empereur.security.DTO;

import java.util.Date;

public class GuardDTO {
    private  Long guardId;

    private Date guardCreateDate;

    private  String guardFullName;

    private  String guardUserName;

    private  String guardIsActif;

    private String guardPassword;

    private String role;

    public GuardDTO() {
    }

    public GuardDTO(Long guardId, Date guardCreateDate, String guardFullName, String guardUserName,
                    String guardIsActif, String guardPassword, String role) {
        this.guardId = guardId;
        this.guardCreateDate = guardCreateDate;
        this.guardFullName = guardFullName;
        this.guardUserName = guardUserName;
        this.guardIsActif = guardIsActif;
        this.guardPassword = guardPassword;
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

    public String getGuardIsActif() {
        return guardIsActif;
    }

    public void setGuardIsActif(String guardIsActif) {
        this.guardIsActif = guardIsActif;
    }

    public String getGuardPassword() {
        return guardPassword;
    }

    public void setGuardPassword(String guardPassword) {
        this.guardPassword = guardPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String string) {
        this.role = role;
    }
}
