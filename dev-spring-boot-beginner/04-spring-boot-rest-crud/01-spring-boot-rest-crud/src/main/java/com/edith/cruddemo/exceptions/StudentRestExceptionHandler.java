package com.edith.cruddemo.exceptions;

import com.edith.cruddemo.errors.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentRestExceptionHandler {

    // Add Exception Handler for StudentNotFoundException
    @ExceptionHandler
    ResponseEntity<StudentErrorResponse> ExceptionHandler(StudentNotFoundException exc) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Add exception handler for any exceptions
    @ExceptionHandler
    ResponseEntity<StudentErrorResponse> Hnadler(Exception exc){
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
