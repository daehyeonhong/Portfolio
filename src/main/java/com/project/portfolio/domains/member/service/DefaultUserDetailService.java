package com.project.portfolio.domains.member.service;

import com.project.portfolio.domains.member.domain.response.LoginResponse;
import com.project.portfolio.domains.member.domain.response.UserDetailsDto;
import com.project.portfolio.domains.member.repository.MemberRepository;
import com.project.portfolio.domains.model.enumerate.authority.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.memberRepository.findOneByUsername(username)
                .map(this::createUser)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    private UserDetails createUser(LoginResponse member) {
        final String username = member.getUsername();
        if (!member.isActivated())
            throw new DisabledException(username);
        return UserDetailsDto.builder()
                .username(username)
                .password(member.getPassword())
                .authorities(member.getAuthorities().stream()
                        .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                        .collect(Collectors.toSet()))
                .authorities(Set.of(Authority.USER))
                .enabled(member.isActivated())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
    }
}
