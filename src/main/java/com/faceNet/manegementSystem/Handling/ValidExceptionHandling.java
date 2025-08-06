package com.faceNet.manegementSystem.Handling;


import com.faceNet.manegementSystem.Common.AppConstant;
import com.faceNet.manegementSystem.Common.CommonEnum;
import com.faceNet.manegementSystem.models.respone.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidExceptionHandling {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(400).body(new ErrorResponse(AppConstant.SYSTEM_BAD_REQUEST, CommonEnum.INPUT_INVALID.getKey(), CommonEnum.INPUT_INVALID.getKey(), errors, CommonEnum.INPUT_INVALID.getValue()));

    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleForbiddenExceptions(AccessDeniedException ex) {
        return ResponseEntity.status(403).body(new ErrorResponse(AppConstant.FORBIDDEN, CommonEnum.INPUT_INVALID.getKey(), CommonEnum.FORBIDDEN.getKey(), ex.getMessage(), CommonEnum.FORBIDDEN.getValue()));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleGeneric(Exception ex) {
        return ResponseEntity.status(500).body(new ErrorResponse(AppConstant.INTERNAL_SERVER_ERROR, CommonEnum.INPUT_INVALID.getKey(), CommonEnum.INTERNAL_SERVER_ERROR.getKey(), ex.getMessage(), CommonEnum.INTERNAL_SERVER_ERROR.getValue()));
    }

}
