package com.example.GreenStitch_Backend_Assignment.Exceptions;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ExecutionControl.UserException.class)
    public ResponseEntity<ErrorDetails> myExceptionHandler(ExecutionControl.UserException userException , WebRequest webReq)
    {
        ErrorDetails errorDetails  = new ErrorDetails();
        errorDetails.setDescription(webReq.getDescription(false));
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setMessage(userException.getMessage());

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> myExceptionHandler(MethodArgumentNotValidException argValidExcep)
    {
        ErrorDetails errorDetails  = new ErrorDetails();
        errorDetails.setDescription("getting Error");
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setMessage(argValidExcep.getFieldError().getDefaultMessage());

        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);

    }
}
