package com.ecust.appv1boatbackend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class DefaultExceptionHandler {

    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<String> handleLoginFailedException(Exception ex) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed or Expired");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
}
