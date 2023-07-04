package com.oidc.auth.service;

import com.oidc.auth.dto.OAuthMember;
import com.oidc.auth.dto.TokenResponse;
import com.oidc.auth.support.JwtTokenProvider;
import com.oidc.auth.support.OAuthClient;
import com.oidc.auth.support.OAuthEndpoint;
import com.oidc.domain.member.domain.Member;
import com.oidc.domain.member.domain.SocialType;
import com.oidc.domain.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class AuthService {


    private final OAuthEndpoint oAuthEndpoint;
    private final OAuthClient oAuthClient;

    private final MemberService memberService;

    private final JwtTokenProvider jwtTokenProvider;


    public AuthService(final OAuthEndpoint oAuthEndpoint, final OAuthClient oAuthClient
    , final MemberService memberService, final JwtTokenProvider jwtTokenProvider) {
        this.oAuthEndpoint = oAuthEndpoint;
        this.oAuthClient = oAuthClient;
        this.memberService = memberService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String generateGoogleLink() {
            return oAuthEndpoint.generate();
    }

    @Transactional
    public TokenResponse generateTokenWithCode(final String code) {
        // 전달 받은 인가코드 & 필수 파라미터를 포함해서 액세스 토큰 요청
        OAuthMember oAuthMember = oAuthClient.getOAuthMember(code);

        String email = oAuthMember.getEmail();

        saveMemberIfNotExists(oAuthMember, email);

        // Resource Owner & Client 확인 jwtToken 생성
        Member foundMember = memberService.findByEmail(email);
        String accessToken = jwtTokenProvider.createToken(String.valueOf(foundMember.getId()));

        return new TokenResponse(accessToken);
    }

    private void saveMemberIfNotExists(final OAuthMember oAuthMember, final String email) {
        if (!memberService.existByEmail(email)) {
            memberService.save(generateMemberBy(oAuthMember));
        }
    }

    private Member generateMemberBy(final OAuthMember oAuthMember) {
        return new Member(oAuthMember.getEmail(), SocialType.GOOGLE);
    }
}