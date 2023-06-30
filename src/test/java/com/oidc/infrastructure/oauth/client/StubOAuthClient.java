package com.oidc.infrastructure.oauth.client;


public class StubOAuthClient implements OAuthClient {

    @Override
    public OAuthMember getOAuthMember(final String code) {
        return new OAuthMember("fancy.junyongmoon@gmail.com");
    }
}