package com.github.sprise233.bumentong.aspect;

import com.github.sprise233.bumentong.entity.OperateLog;
import com.github.sprise233.bumentong.service.OperateLogService;
import com.github.sprise233.bumentong.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class OperateLogAspect {

    @Pointcut("@annotation(com.github.sprise233.bumentong.anno.Log)")
    private void pointCut() {}

    @Autowired
    OperateLogService operateLogService;
    @Around("pointCut()")
    public Object logMethodExecutionDetails(ProceedingJoinPoint joinPoint) throws Throwable {

        OperateLog operateLog = new OperateLog();

        BigInteger currentTime = BigInteger.valueOf(System.currentTimeMillis());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setOperateUser(JWTUtils.getUserId());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setOperateEmpUsername(JWTUtils.getUserName());

        Object result = joinPoint.proceed();
        operateLog.setCostTime(BigInteger.valueOf(System.currentTimeMillis()).subtract(currentTime));
        operateLog.setReturnValue(result.toString());

        operateLogService.insertOperateLog(operateLog);

        return result;
    }

}
