package com.pet.manager.exception;

import com.pet.manager.controller.HttpErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler({PetNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(PetNotFound exception) {
        return new HttpErrorResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
    @ExceptionHandler({DuplicatePetException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public HttpErrorResponse handleGenericException(DuplicatePetException exception) {
        return new HttpErrorResponse(
                409,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}