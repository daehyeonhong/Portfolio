package com.project.portfolio.module.member.service;

import com.project.portfolio.module.member.domain.entity.MemberEntity;
import com.project.portfolio.module.member.domain.request.LoginRequest;

public interface MemberService {
    MemberEntity save(LoginRequest loginRequest);
}
