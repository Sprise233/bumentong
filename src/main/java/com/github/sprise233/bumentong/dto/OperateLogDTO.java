package com.github.sprise233.bumentong.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class OperateLogDTO {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operateTime;
    private Integer operateUser;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private BigInteger costTime;
    private String className;
    private String operateEmpName;
}
