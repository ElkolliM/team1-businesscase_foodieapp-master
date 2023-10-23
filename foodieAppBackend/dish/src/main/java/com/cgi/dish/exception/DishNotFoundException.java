package com.cgi.dish.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Dish with specified details not found")

public class DishNotFoundException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;



}
