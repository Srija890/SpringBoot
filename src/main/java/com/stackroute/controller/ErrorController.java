package com.stackroute.controller;

import com.stackroute.Exceptions.TrackAlreadyExistsExceptions;
import com.stackroute.Exceptions.TrackNotFoundExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value= TrackAlreadyExistsExceptions.class)
    public ResponseEntity<String> exception()
    {
      return new ResponseEntity<String>("Trackalreadyexistexception", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value= TrackNotFoundExceptions.class)
    public ResponseEntity<String> exception1(TrackNotFoundExceptions exception1)
    {
      return new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
    }
  }


