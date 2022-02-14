package com.project.portfolio.domains.model.enumerate.authority;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Authority implements GrantedAuthority {
    ADMIN("ROLE_ADMIN"), MANAGER("ROLE_MANAGER"), USER("ROLE_USER"), GUEST("ROLE_GUEST");
    final String authority;
}
