package com.oidc.auth.support;

@FunctionalInterface
public interface OAuthEndpoint {

    String generate();
}