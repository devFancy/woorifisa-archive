package com.oidc.auth.dto;

public class OAuthMember {

    private final String email;


    public OAuthMember(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}