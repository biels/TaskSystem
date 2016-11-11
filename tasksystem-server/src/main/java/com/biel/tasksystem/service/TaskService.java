package com.biel.tasksystem.service;

import com.biel.tasksystem.model.Account;
import com.biel.tasksystem.model.Task;
import com.biel.tasksystem.repository.AccountRepository;
import com.biel.tasksystem.repository.TaskRepository;
import com.biel.tasksystem.service.exceptions.TaskNotFoundException;
import com.biel.tasksystem.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Biel on 11/11/2016.
 */
@RestController
@RequestMapping("/users/{userId}")
public class TaskService {
    AccountRepository accountRepository;
    TaskRepository taskRepository;

    @Autowired
    public TaskService(AccountRepository accountRepository, TaskRepository taskRepository) {
        this.accountRepository = accountRepository;
        this.taskRepository = taskRepository;
    }

    @RequestMapping(name = "/task", method = RequestMethod.GET)
    Task get(@PathVariable String userId, @RequestParam String path) throws UserNotFoundException, TaskNotFoundException {
        return taskRepository.findOneByAccountAndPath(getAccount(userId), path).orElseThrow(() -> new TaskNotFoundException(path));
    }
    @RequestMapping(name = "/task", method = RequestMethod.POST)
    ResponseEntity create(@PathVariable String userId, @RequestParam String path){
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    Account getAccount(String userId) throws UserNotFoundException {
        //Authenticate user here
        return accountRepository.findByUsername(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

}
