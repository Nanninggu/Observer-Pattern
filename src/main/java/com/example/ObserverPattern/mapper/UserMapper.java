package com.example.ObserverPattern.mapper;

import com.example.ObserverPattern.dto.User;
import com.example.ObserverPattern.dto.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    void insertUser(User user);

    void insertEvent1(String uuid, String timestamp, String payload);

    void insertEvent2(String uuid, String timestamp, String payload);

    void insertEvent3(String uuid, String timestamp, String payload);

    List<User> getUsers();

}
