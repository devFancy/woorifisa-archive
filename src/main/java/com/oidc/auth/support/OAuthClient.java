package com.oidc.auth.support;


@FunctionalInterface
public interface OAuthClient {
    OAuthMember getOAuthMember(final String code);
}
