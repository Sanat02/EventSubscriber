package com.example.demo.dao;

import com.example.demo.models.EventSubscribers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventSubscribeDao {
    private final JdbcTemplate jdbcTemplate;

    public HttpStatus subscribeEvent(EventSubscribers eventSubscribers) {
        String sql = "INSERT INTO event_subscribers(eventId , email , registrationDate) " +
                "VALUES(? ,? ,?  )";
        int row=jdbcTemplate.update(sql,eventSubscribers.getEventId(),eventSubscribers.getEmail(),
                eventSubscribers.getRegistrationDate());
        if(row!=1){
            return HttpStatus.EXPECTATION_FAILED;
        }
        return HttpStatus.OK;

    }
}
