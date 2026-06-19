package com.university.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String uri = request.getRequestURI();
        String method = request.getMethod();

        // Log login attempts
        if (uri.equals("/login") && method.equals("POST")) {
            logger.info("Login attempt at " + LocalDateTime.now() + " from IP: " + request.getRemoteAddr());
        }

        // Log course registration
        if (uri.startsWith("/register/") && method.equals("POST")) {
            logger.info("Course registration attempt at " + LocalDateTime.now() + " from IP: " + request.getRemoteAddr());
        }

        return true;
    }
}
