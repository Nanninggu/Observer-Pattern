package com.example.ObserverPattern.service;

import com.example.ObserverPattern.dto.User;
import com.example.ObserverPattern.dto.UserEvent;
import com.example.ObserverPattern.dto.Users;
import com.example.ObserverPattern.mapper.UserMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final ApplicationEventPublisher eventPublisher;
    private final UserMapper userMapper;

    public UserService(ApplicationEventPublisher eventPublisher, UserMapper userMapper) {
        this.eventPublisher = eventPublisher;
        this.userMapper = userMapper;
    }

    public void createUser(String username) {
        User user = new User(username);
        logger.info("User created: {}", user);
        userMapper.insertUser(user);
        UserEvent userEvent = user.createUserEvent();
        eventPublisher.publishEvent(userEvent); // ❗⭐ 해당 이벤트를 발행하지 않으면 UserEventListener의 handleUserEvent가 호출되지 않는다.
        logger.info("User event published: {}", userEvent);
    }

    public List<User> getUsers() {
        return userMapper.getUsers();
    }

}
