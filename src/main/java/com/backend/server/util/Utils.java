package com.backend.server.util;

import com.backend.server.model.ApiErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public final class Utils {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private Utils() {

    }

    public static boolean isCausedBy(Throwable ex, Class<? extends Throwable> causeClass) {
        while (ex != null) {
            if (causeClass.isInstance(ex)) {
                return true;
            }
            ex = ex.getCause();
        }
        return false;
    }

    public static void sendUnauthorizedResponse(HttpServletRequest request , HttpServletResponse response) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                "Unauthorized",
                request.getRequestURI()
        );

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        try {
            response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
