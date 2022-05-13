package com.java.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentErrorResponseHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> exceptionHandler(StudentNotFoundException e){
        StudentErrorResponse response=new StudentErrorResponse();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> differentExc(Exception e){
        StudentErrorResponse response=new StudentErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
