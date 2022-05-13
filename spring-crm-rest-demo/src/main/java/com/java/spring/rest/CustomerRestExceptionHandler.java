package com.java.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> throwExc(CustomerNotFoundException e){
        CustomerErrorResponse customerErrorResponse=new CustomerErrorResponse();

        customerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        customerErrorResponse.setMessage(e.getMessage());
        customerErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> allExc(Exception e){
        CustomerErrorResponse customerErrorResponse=new CustomerErrorResponse();

        customerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customerErrorResponse.setMessage(e.getMessage());
        customerErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse,HttpStatus.BAD_REQUEST);
    }


}
