package com.thy.frontback.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.thy.frontback.Exceptions.E_400.*;
import com.thy.frontback.Exceptions.E_500.*;
import com.thy.frontback.Exceptions.Entities.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleBadRequest(BadRequest ex) {
        return new ExceptionResponse(400, "Bad Request", ex.getMessage(), LocalDateTime.now());
    }
    
    @ExceptionHandler(Unauthorized.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionResponse handleUnauthorized(Unauthorized ex) {
        return new ExceptionResponse(401, "Unauthorized", ex.getMessage(), LocalDateTime.now());
    }
    
    @ExceptionHandler(Forbidden.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handleForbidden(Forbidden ex) {
        return new ExceptionResponse(403, "Forbidden", ex.getMessage(), LocalDateTime.now());
    }
    
    @ExceptionHandler(NotFoundExc.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFound(NotFoundExc ex) {
        return new ExceptionResponse(404, "Not Found", ex.getMessage(), LocalDateTime.now());
    }
    
    @ExceptionHandler(Conflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handleConflict(Conflict ex) {
        return new ExceptionResponse(409, "Conflict", ex.getMessage(), LocalDateTime.now());
    }
    
    @ExceptionHandler(InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleInternalServerError(InternalServerError ex) {
        return new ExceptionResponse(500, "Internal Server Error", ex.getMessage(), LocalDateTime.now());
    }

}
