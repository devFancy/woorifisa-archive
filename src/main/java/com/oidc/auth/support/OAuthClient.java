package com.oidc.auth.support;


import com.oidc.auth.dto.OAuthMember;

@FunctionalInterface
public interface OAuthClient {
    OAuthMember getOAuthMember(final String code);
}
