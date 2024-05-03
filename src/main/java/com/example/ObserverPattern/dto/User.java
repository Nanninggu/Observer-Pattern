package com.example.ObserverPattern.dto;

public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // if user is created, create a user event
    public UserEvent createUserEvent() {
        return new UserEvent(this, "User created with username: " + username);
    }

}