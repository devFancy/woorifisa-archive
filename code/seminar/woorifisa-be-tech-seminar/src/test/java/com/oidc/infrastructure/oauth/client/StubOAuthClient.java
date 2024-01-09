package com.oidc.infrastructure.oauth.client;


import com.oidc.auth.dto.OAuthMember;
import com.oidc.auth.support.OAuthClient;

public class StubOAuthClient implements OAuthClient {

    @Override
    public OAuthMember getOAuthMember(final String code) {
        return new OAuthMember("fancy.junyongmoon@gmail.com");
    }
}