package com.biel.tasksystem.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Biel on 11/11/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String userId) {
        super("Could not find user " + userId + ".");
    }
}
