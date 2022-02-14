package com.project.portfolio.domains.member.service;

import com.project.portfolio.domains.member.domain.response.LoginResponse;

public interface LoginService {
    LoginResponse login(String username);
}
