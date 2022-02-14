package com.project.portfolio.domains.member.service;

import com.project.portfolio.domains.member.domain.entity.MemberEntity;
import com.project.portfolio.domains.member.domain.request.LoginRequest;
import com.project.portfolio.domains.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public MemberEntity save(final LoginRequest loginRequest) {
        return memberRepository.save(new MemberEntity(null, loginRequest.getUsername(), loginRequest.getPassword(), Boolean.FALSE));
    }
}
