package com.example.demo.dao;

import com.example.demo.models.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventDao {
    private final JdbcTemplate jdbcTemplate;

    public void createEvent(Event event) {
        String sql = "INSERT INTO events(dateAndTime,name,description) " +
                "VALUES(? , ? , ?)";
        jdbcTemplate.update(sql, event.getDateAndTime(), event.getName(), event.getDescription());
    }

    public List<Event> getAllEvents(){
        String sql="SELECT * FROM events";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Event.class));
    }
}
