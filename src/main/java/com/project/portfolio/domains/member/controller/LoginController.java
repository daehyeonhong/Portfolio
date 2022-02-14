package com.project.portfolio.domains.member.controller;

import com.project.portfolio.domains.member.domain.request.LoginRequest;
import com.project.portfolio.domains.member.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping(value = "/login")
    public void login(@RequestBody final LoginRequest loginRequest) {
        this.loginService.login(loginRequest.getUsername());
    }
}
