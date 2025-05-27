package com.github.sprise233.bumentong.filter;

import com.github.sprise233.bumentong.utils.JWTUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpRequest.getRequestURI().equals("/login")) {
            chain.doFilter(request, response);
        }

        if (httpRequest.getHeader("token") == null || httpRequest.getHeader("token").isEmpty()) {
            httpResponse.setStatus(401);
        }

        try {
//            System.out.println(httpRequest.getHeader("token"));
            JWTUtils.parseUserByToken(httpRequest.getHeader("token"));
            chain.doFilter(request, response);
        } catch (Exception e) {
            httpResponse.setStatus(401);
        }
    }
}
