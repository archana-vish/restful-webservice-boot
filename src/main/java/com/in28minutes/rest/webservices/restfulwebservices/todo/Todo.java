package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.Date;

public class Todo {

    private long id;
    private String username;
    private String description;
    private Date targeDate;
    private boolean done;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargeDate() {
        return targeDate;
    }

    public void setTargeDate(Date targeDate) {
        this.targeDate = targeDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Todo(long id, String username, String description, Date targeDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targeDate = targeDate;
        this.done = done;
    }
}
