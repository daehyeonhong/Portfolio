package com.project.portfolio.module.member.service;

import com.project.portfolio.module.member.domain.entity.MemberEntity;
import com.project.portfolio.module.member.domain.response.LoginResponse;
import com.project.portfolio.module.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatabaseLoginService implements LoginService {
    private final MemberRepository memberRepository;

    @Override
    public LoginResponse login(String username) {
        final MemberEntity memberEntity = this.memberRepository
                .findByUsername(username)
                .orElseThrow(IllegalArgumentException::new);
        return new LoginResponse(memberEntity.getId(), memberEntity.getUsername(), memberEntity.getPassword(), memberEntity.getActivated());
    }
}
