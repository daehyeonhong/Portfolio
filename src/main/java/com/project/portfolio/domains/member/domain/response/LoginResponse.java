package com.project.portfolio.domains.member.domain.response;

import com.project.portfolio.domains.model.enumerate.authority.Authority;
import java.util.Set;

public interface LoginResponse {
    String getUsername();

    String getPassword();

    boolean isActivated();

    Set<Authority> getAuthorities();
}
