package com.mw.pub.exception;

import com.mw.pub.dto.ErrorsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(UserNotFound.class)
        public ProblemDetail  userNotFound(UserNotFound ex){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
                System.out.println("The field errors are: ");
               ex.getBindingResult().getFieldErrors().forEach((error->{
                   System.out.println(error.getField() + " : " + error.getDefaultMessage());
                }));
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,ex.getBindingResult().getFieldErrors().toString());
        }
}