package com.example.demo.dao;

import com.example.demo.models.EventSubscribers;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventSubscribeDao {
    private final JdbcTemplate jdbcTemplate;

    public String subscribeEvent(EventSubscribers eventSubscribers) {
        String sql = "INSERT INTO event_subscribers(eventId , email , registrationDate) " +
                "VALUES(? ,? ,?  )";
        int row = jdbcTemplate.update(sql, eventSubscribers.getEventId(), eventSubscribers.getEmail(),
                eventSubscribers.getRegistrationDate());


        return "Registered successfully!";

    }

    public EventSubscribers getByIdAndEmail(int eventId, String email) {
        try {
            String sql = "SELECT * FROM event_subscribers WHERE eventId = ? AND  " +
                    "email = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(EventSubscribers.class),
                    eventId, email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<EventSubscribers> getSubscribersByEmail(String email) {
        String sql = "SELECT * FROM event_subscribers WHERE email = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EventSubscribers.class), email);

    }

    public String deleteSubscriber(int id, String email) {
        String sql = "DELETE from event_subscribers WHERE id = ? AND email = ?";
        int rowIsAffected = jdbcTemplate.update(sql, id, email);
        if(rowIsAffected!=1){
            return "No such data";
        }
        return "SUCCESSFUL DELETE!";

    }

}
