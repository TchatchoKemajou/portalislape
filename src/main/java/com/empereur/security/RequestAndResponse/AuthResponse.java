package com.empereur.security.RequestAndResponse;

import com.empereur.security.Models.Gardien;

public class AuthResponse {
    private Gardien user;
    private String accessToken;

    public AuthResponse(Gardien user, String accessToken) {
        this.user = user;
        this.accessToken = accessToken;
    }

    public AuthResponse() {
    }

    public Gardien getUser() {
        return user;
    }

    public void setUser(Gardien user) {
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
