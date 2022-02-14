package com.project.portfolio.common.config.security;

import com.project.portfolio.domains.model.enumerate.authority.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
        http.csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/login", "/user", "/signUp", "/usernameCheck", "/departments", "/positions").permitAll()
//                .antMatchers("/project/**").authenticated()
                .antMatchers("/user").hasAuthority(Authority.USER.getAuthority())
                .antMatchers("/memberList", "/user/passwordReset/**", "/userModify/**", "/users").hasAuthority(Authority.ADMIN.getAuthority())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .loginProcessingUrl("/loginProcess")
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/h2-console/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
