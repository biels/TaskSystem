package com.biel.tasksystem.repository;

import com.biel.tasksystem.model.Account;
import com.biel.tasksystem.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

/**
 * Created by Biel on 11/11/2016.
 */
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    Optional<Task> findOneByAccountAndPath(Account account, String path);
    List<Event> findManyByAccount(Account account);
}
