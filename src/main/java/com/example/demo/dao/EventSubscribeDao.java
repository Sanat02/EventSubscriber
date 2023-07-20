package com.example.demo.dao;

import com.example.demo.models.EventSubscribers;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventSubscribeDao {
    private final JdbcTemplate jdbcTemplate;

    public void subscribeEvent(EventSubscribers eventSubscribers) {
        String sql = "INSERT INTO event_subscribers(eventId , email , registrationDate) " +
                "VALUES(? ,? ,?  )";
        jdbcTemplate.update(sql,eventSubscribers.getEventId(),eventSubscribers.getEmail(),
                eventSubscribers.getRegistrationDate());

    }
}
