package com.project.portfolio.domains.model.enumerate.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    /*INVALID_ELEMENT(BAD_REQUEST, "리프레시 토큰이 유효하지 않습니다"),*/
    INVALID_PARSING_DATA(BAD_REQUEST, "데이터 타입을 확인하세요"),
    INVALID_PASSWORD(BAD_REQUEST, "비밀번호를 확인하세요"),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    INVALID_AUTH_TOKEN(UNAUTHORIZED, "권한 정보가 없는 사용자입니다"),

    /* 403 FORBIDDEN : 권한 거절 */
    INVALID_LOGIN_INFO(FORBIDDEN, "아이디나 비밀번호를 확인하세요."),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    USER_NOT_FOUND(NOT_FOUND, "해당 유저 정보를 찾을 수 없습니다"),
    USER_NOT_ACTIVATED(NOT_FOUND, "비활성화된 유저입니다."),

    /* 406 NOT_ACCEPTABLE: 요청 미충족*/
    INVALID_ELEMENT(NOT_ACCEPTABLE, "유효하지 않은 입력입니다."),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다");

    final HttpStatus httpStatus;
    final String detail;

}
