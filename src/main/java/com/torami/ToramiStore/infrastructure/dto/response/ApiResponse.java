package com.torami.ToramiStore.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private int status;
    private String message;
    private T data;
    private LocalDateTime timestamp;
    private String errorCode;
    private String path;

    public ApiResponse(int status, String message, T data, String path) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
        this.path = path;
    }

    public ApiResponse(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.data = null;
        this.timestamp = LocalDateTime.now();
        this.path = path;
    }

    public ApiResponse(int status, String message, String errorCode, String path) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now();
        this.path = path;
    }

    public static <T> ApiResponse<T> success(T data, String message, String path) {
        return new ApiResponse<>(200, message, data, path);
    }

    public static <T> ApiResponse<T> created(T data, String message, String path) {
        return new ApiResponse<>(201, message, data, path);
    }

    public static <T> ApiResponse<T> noContent(String message, String path) {
        return new ApiResponse<>(204, message, path);
    }

    public static <T> ApiResponse<T> badRequest(String message, String errorCode, String path) {
        return new ApiResponse<>(400, message, errorCode, path);
    }

    public static <T> ApiResponse<T> notFound(String message, String errorCode, String path) {
        return new ApiResponse<>(404, message, errorCode, path);
    }

    public static <T> ApiResponse<T> internalError(String message, String errorCode, String path) {
        return new ApiResponse<>(500, message, errorCode, path);
    }

    public static <T> ApiResponse<T> error(int status, String message, String errorCode, String path) {
        return new ApiResponse<>(status, message, errorCode, path);
    }
}