package com.github.sprise233.bumentong.interceptor;

import com.github.sprise233.bumentong.utils.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截请求: url:{}, ip:{}", request.getRequestURI(), request.getRemoteAddr());
        if (request.getRequestURI().equals("/login")) {
            return true;
        }

        if (request.getHeader("token") == null || request.getHeader("token").isEmpty()) {
            response.setStatus(401);
            return false;
        }

        try {
            JWTUtils.parseUserByToken(request.getHeader("token"));
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }

        return true;
    }
}
