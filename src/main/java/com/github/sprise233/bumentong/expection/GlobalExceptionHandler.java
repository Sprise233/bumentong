package com.github.sprise233.bumentong.expection;

import com.github.sprise233.bumentong.dto.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = Exception.class)
    public ResultDTO handleException(Exception e) {
        return ResultDTO.error(e.getMessage());
    }
}
