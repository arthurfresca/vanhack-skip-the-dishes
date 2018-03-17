package com.skipthedishes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "List Is empty")
public class EmptyListException extends Exception {
    static final long serialVersionUID = -3387516993334229948L;


    public EmptyListException(String message) {
        super(message);
    }

}
