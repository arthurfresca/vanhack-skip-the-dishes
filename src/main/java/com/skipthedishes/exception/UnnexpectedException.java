package com.skipthedishes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Something unnexpected happened. Try again later")
public class UnnexpectedException extends Exception {
    static final long serialVersionUID = -3387516993334229948L;


    public UnnexpectedException(String message) {
        super(message);
    }

}
