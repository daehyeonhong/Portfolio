package com.project.portfolio.module.member.service;

import com.project.portfolio.module.member.domain.response.LoginResponse;

public interface LoginService {
    LoginResponse login(String username);
}
