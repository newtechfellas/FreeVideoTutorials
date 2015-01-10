package com.newtechfellas.videotutorials.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 8/16/14.
 * Time: 7:30 PM
 */
public class ObjectNotFoundException extends HttpStatusCodeException {

    public ObjectNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
