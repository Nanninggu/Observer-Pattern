package com.example.ObserverPattern.listener;

import com.example.ObserverPattern.dto.User;
import com.example.ObserverPattern.dto.UserEvent;
import com.example.ObserverPattern.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserEventListener {

    @Autowired
    private UserMapper userMapper;

    // ❗⭐ UserService의 eventPublisher.publishEvent(userEvent); 메소드를 통해 발생한 이벤트를 받아 처리
    // ❗⭐ 이벤트를 받아서 처리하는 메소드, @EventListener 어노테이션을 사용하여 이벤트를 받아 처리
    @EventListener
    public void handleUserEvent(UserEvent userEvent) {
        System.out.println("Received user event - " + userEvent.getMessage());

        userMapper.insertUser(new User(userEvent.getMessage()));

        /**
         * 이벤트를 3개의 테이블에 저장하는 로직 구현
         *  - 전달받은 이벤트 payload와 UUID 그리고 Timestamp를 추가하여 event1,2,3 table에 저장
         */

        String uuid = UUID.randomUUID().toString();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String payload = userEvent.getMessage();
        // event1 table에 저장
        userMapper.insertEvent1(uuid, timestamp, payload);

        // event2 table에 저장
        userMapper.insertEvent2(uuid, timestamp, payload);

        // event3 table에 저장
        userMapper.insertEvent3(uuid, timestamp, payload);
    }

}
