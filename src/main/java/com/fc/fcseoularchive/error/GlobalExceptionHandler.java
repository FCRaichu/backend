package com.fc.fcseoularchive.error;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 전역 예외처리
 * 사용법 :
 * throw new ApiException(HttpStatus.NOT_FOUND, "404", "NOT_FOUND", "유저를 찾을 수 없습니다");
 * <p>
 * 출력 예시 :
 * HTTP/1.1 404 Not Found
 * Content-Type: application/json
 * {
 * "status" : "404",
 * "code": "USER_NOT_FOUND",
 * "message": "유저를 찾을 수 없습니다."
 * }
 */

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException e, HttpServletRequest req) {

        ErrorResponse errorResponse = new ErrorResponse(e.getStatus(), e.getCode(), e.getMessage());

        return ResponseEntity.status(e.getHttpStatus()).body(errorResponse);

    }

}
