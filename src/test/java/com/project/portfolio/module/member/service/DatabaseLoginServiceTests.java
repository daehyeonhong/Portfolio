package com.project.portfolio.module.member.service;

import com.project.portfolio.module.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DatabaseLoginServiceTests {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    LoginService loginService;

    @Test
    void login() {
        Assertions.assertThatThrownBy(() -> this.loginService.login("Star")).isInstanceOf(IllegalArgumentException.class);
    }
}
