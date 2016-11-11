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
@RequestMapping("/account/{userId}/task")
public class TaskService {
    AccountService accountService;
    TaskRepository taskRepository;

    @Autowired
    public TaskService(AccountService accountService, TaskRepository taskRepository) {
        this.accountService = accountService;
        this.taskRepository = taskRepository;
    }

    @RequestMapping(name = "", method = RequestMethod.GET)
    Task get(@PathVariable String userId, @RequestParam String path) throws UserNotFoundException, TaskNotFoundException {
        return taskRepository.findOneByAccountAndPath(accountService.getAccount(userId), path).orElseThrow(() -> new TaskNotFoundException(path));
    }
    @RequestMapping(name = "", method = RequestMethod.POST)
    ResponseEntity create(@PathVariable String userId, @RequestParam String path){
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }



}
