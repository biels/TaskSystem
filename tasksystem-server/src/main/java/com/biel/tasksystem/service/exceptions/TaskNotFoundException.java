package com.biel.tasksystem.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Biel on 11/11/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Task not found")
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String path) {
        super("Task not found at " + path + ".");
    }
}
