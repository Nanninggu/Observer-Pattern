package com.example.ObserverPattern.dto;

import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {
    private final String message;

    public UserEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
