package com.bhaskar.kafka.exception;

import com.bhaskar.kafka.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BhaskarErrorHandler.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleBhaskarException(BhaskarErrorHandler bhaskarErrorHandler)
    {
        return Response.builder().statusCode("400").time(LocalDateTime.now()).message(bhaskarErrorHandler.getMessage()).build();
    }
}
