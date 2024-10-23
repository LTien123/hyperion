package com.fanci.Hyperion_be.exception;


import com.fanci.Hyperion_be.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse<?>> handleAppException(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatusCode()).body(ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ApiResponse<?>> handleIOException(IOException e) {
        ErrorCode errorCode = ErrorCode.IO_ERROR;
        return ResponseEntity.status(errorCode.getHttpStatusCode()).body(ApiResponse.builder()
                .code(errorCode.getCode())
                .message(e.getMessage())
                .build());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<?>> handleJsonParseError(HttpMessageNotReadableException ex) {
        ErrorCode errorCode = ErrorCode.JSON_PARSE_ERROR;
        return ResponseEntity.status(errorCode.getHttpStatusCode()).body(ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build());
    }

}
