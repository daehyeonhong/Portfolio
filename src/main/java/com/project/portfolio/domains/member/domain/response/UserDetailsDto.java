package com.project.portfolio.domains.member.domain.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserDetailsDto implements UserDetails, Serializable {
    final String username;
    final String password;
    final Collection<? extends GrantedAuthority> authorities;
    final boolean enabled;
    final boolean accountNonExpired;
    final boolean accountNonLocked;
    final boolean credentialsNonExpired;
}
