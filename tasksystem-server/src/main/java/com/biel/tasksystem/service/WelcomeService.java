package com.biel.tasksystem.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Biel on 11/11/2016.
 */
@RestController("/welcome")
public class WelcomeService {
    @RequestMapping()
    String welcome(){
        return "Welcome to the TaskSystem API";
    }
}
