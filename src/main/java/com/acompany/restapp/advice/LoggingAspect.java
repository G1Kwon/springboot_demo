package com.acompany.restapp.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.acompany.restapp.controller.UserController.*(..))")
    public Object setLog(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("실행 시작: "
                + pjp.getSignature().getDeclaringTypeName() + "."
                + pjp.getSignature().getName());
        long startMillis = System.currentTimeMillis();
        Object result = pjp.proceed();
        long executionMillis = System.currentTimeMillis() - startMillis;
        System.out.println("실행 완료: " + executionMillis + "밀리초 소요됨 :"
                + pjp.getSignature().getDeclaringTypeName() + "."
                + pjp.getSignature().getName());

        return result;
    }

    @Before("execution(* com.acompany.restapp.service.*.get*())")
    //get으로 시작하는 모든 메소드가 실행되기 전에 아래의 함수가 반드시 실행이 된다.
    public void logger() {
        System.out.println("logger test before service methods");
    }
}
