package com.biel.tasksystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by Biel on 11/11/2016.
 */
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    private Account account;

    private String path;
    private String title;
    private String description;
    private Date deadline;
    private double estimatedCompletionTime;

    Task() {
    }

    public Task(String path, String title, String description) {
        this.path = path;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public double getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }

    public void setEstimatedCompletionTime(double estimatedCompletionTime) {
        this.estimatedCompletionTime = estimatedCompletionTime;
    }
}
