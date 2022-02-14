package com.project.portfolio.domains.member.controller;

import com.project.portfolio.domains.member.domain.request.LoginRequest;
import com.project.portfolio.domains.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping(value = "/members")
    public void save(@RequestBody final LoginRequest loginRequest) {
        final Long id = memberService.save(loginRequest).getId();
        System.out.println("id = " + id);
    }
}
