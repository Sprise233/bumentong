package com.github.sprise233.bumentong.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class OperateLog {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operateTime;
    private Integer operateUser;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private BigInteger costTime;
    private String className;
    private String operateEmpUsername;
}
