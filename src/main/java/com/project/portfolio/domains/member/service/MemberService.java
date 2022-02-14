package com.project.portfolio.domains.member.service;

import com.project.portfolio.domains.member.domain.entity.MemberEntity;
import com.project.portfolio.domains.member.domain.request.LoginRequest;

public interface MemberService {
    MemberEntity save(LoginRequest loginRequest);
}
