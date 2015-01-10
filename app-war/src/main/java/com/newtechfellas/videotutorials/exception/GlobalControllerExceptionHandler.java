package com.newtechfellas.videotutorials.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/9/15.
 * Time: 12:00 PM
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<String> handleMyException(HttpStatusCodeException ex) {
        return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
    }
}
