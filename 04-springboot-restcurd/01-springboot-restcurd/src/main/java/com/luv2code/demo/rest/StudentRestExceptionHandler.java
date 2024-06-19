package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class StudentRestExceptionHandler {


    // add exception handling code
    @ExceptionHandler
    public ResponseEntity<StudentErroResponse> handleException(StudentNotFoundException exc){

        StudentErroResponse error=new StudentErroResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add another exception which can handle any exception

    @ExceptionHandler
    public ResponseEntity<StudentErroResponse> handleException(Exception exc){

        StudentErroResponse error=new StudentErroResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }
}
