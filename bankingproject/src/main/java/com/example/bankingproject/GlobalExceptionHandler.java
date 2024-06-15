package com.example.bankingproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
	public class GlobalExceptionHandler {
	
       // @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
	     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        
	      //  return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	        
	     //   public String handlerExcep(RuntimeException e) {
        //	return e.getMessage();
	    }
	}


