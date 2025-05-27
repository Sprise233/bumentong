package com.github.sprise233.bumentong.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.github.sprise233.bumentong.controller.*.*(..))")
    public void logPointCut() {};

    @Around("logPointCut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("前端发来请求了：className: {}, methodName: {}, args: {}", className, methodName, args);

        Object result = joinPoint.proceed();

        log.info("后端返回了： {}", result);
        return result;
    }
}
