package com.empereur.security.RequestAndResponse;

public class AuthRequest {

    private  String guardUserName;

    private String guardPassword;

    public AuthRequest() {
    }

    public AuthRequest(String guardUserName, String guardPassword) {
        this.guardUserName = guardUserName;
        this.guardPassword = guardPassword;
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
}
