package com.project.portfolio.module.member.domain.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LoginResponse {
    Long id;
    String username;
    String password;
    Boolean activated;
}
