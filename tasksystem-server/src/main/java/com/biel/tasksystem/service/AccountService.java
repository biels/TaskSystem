package com.biel.tasksystem.service;

import com.biel.tasksystem.model.Account;
import com.biel.tasksystem.repository.AccountRepository;
import com.biel.tasksystem.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

/**
 * Created by Biel on 11/11/2016.
 */
@RestController
@RequestMapping("/accounts")
public class AccountService {
    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    String list(){
        return MessageFormat.format("{0} accounts registered on the server.", accountRepository.count());
    }
    //Register, login, ...
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    Account summary(@PathVariable String userId) throws UserNotFoundException {
        return getAccount(userId);
    }

    protected Account getAccount(String userId) throws UserNotFoundException {
        //Authenticate user here
        return accountRepository.findByUsername(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }
}
