package com.project.portfolio.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Around(
            "execution(* com.project.portfolio.controller..*Controller.*(..))||" +
                    "execution(* com.project.portfolio.service..*Impl.*(..))"
    )
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        final Signature signature = joinPoint.getSignature();
        log.info("{}.{}()", signature.getDeclaringTypeName(), signature.getName());
        return joinPoint.proceed();
    }

    @Around(
            "execution(* com.project.portfolio.repository..*Repository.*(..))"
    )
    public Object printArgs(ProceedingJoinPoint joinPoint) throws Throwable {
        final Signature signature = joinPoint.getSignature();
        log.info("{}.{}()", signature.getDeclaringTypeName(), signature.getName());
        log.info("{}", joinPoint.getArgs());
        return joinPoint.proceed();
    }

}
