package com.torami.ToramiStore.infrastructure.config.exception;

import com.torami.ToramiStore.domain.exceptions.filters.Category.*;
import com.torami.ToramiStore.infrastructure.dto.response.ApiResponse;
import com.torami.ToramiStore.infrastructure.dto.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleCategoryNotFound(
            CategoryNotFoundException ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.notFound(
                ex.getMessage(),
                ex.getErrorCode(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(CategoryInvalidNameException.class)
    public ResponseEntity<ApiResponse<Void>> handleCategoryInvalidName(
            CategoryInvalidNameException ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.badRequest(
                ex.getMessage(),
                ex.getErrorCode(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> handleCategoryAlreadyExists(
            CategoryAlreadyExistsException ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.badRequest(
                ex.getMessage(),
                ex.getErrorCode(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CategoryHasFiguresException.class)
    public ResponseEntity<ApiResponse<Void>> handleCategoryHasFigures(
            CategoryHasFiguresException ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.badRequest(
                ex.getMessage(),
                ex.getErrorCode(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CategoryCannotBeDeletedException.class)
    public ResponseEntity<ApiResponse<Void>> handleCategoryCannotBeDeleted(
            CategoryCannotBeDeletedException ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.badRequest(
                ex.getMessage(),
                ex.getErrorCode(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CategorySaveException.class)
    public ResponseEntity<ApiResponse<Void>> handleCategorySave(
            CategorySaveException ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.internalError(
                ex.getMessage(),
                ex.getErrorCode(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(CategoryDeleteException.class)
    public ResponseEntity<ApiResponse<Void>> handleCategoryDelete(
            CategoryDeleteException ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.internalError(
                ex.getMessage(),
                ex.getErrorCode(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<List<ErrorResponse>>> handleValidationErrors(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        List<ErrorResponse> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorResponse(
                        fieldError.getField(),
                        fieldError.getDefaultMessage(),
                        fieldError.getRejectedValue()
                ))
                .collect(Collectors.toList());

        ApiResponse<List<ErrorResponse>> response = ApiResponse.badRequest(
                "Validation failed",
                "VALIDATION_ERROR",
                request.getRequestURI()
        );
        response.setData(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<Void>> handleConstraintViolation(
            ConstraintViolationException ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.badRequest(
                ex.getMessage(),
                "CONSTRAINT_VIOLATION",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Void>> handleRuntimeException(
            RuntimeException ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.internalError(
                ex.getMessage(),
                "INTERNAL_ERROR",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(
            Exception ex,
            HttpServletRequest request) {
        ApiResponse<Void> response = ApiResponse.internalError(
                ex.getMessage(),
                "INTERNAL_ERROR",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
