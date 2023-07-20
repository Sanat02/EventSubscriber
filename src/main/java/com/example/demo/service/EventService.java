package com.example.demo.service;

import com.example.demo.dao.EventDao;
import com.example.demo.dto.EventDto;
import com.example.demo.models.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventDao eventDao;

    public List<EventDto> getAllEvents() {
        List<Event> events = eventDao.getAllEvents();
        return events.stream()
                .map(e -> EventDto.builder()
                        .id(e.getId())
                        .description(e.getDescription())
                        .name(e.getName())
                        .dateAndTime(e.getDateAndTime())
                        .build()
                ).toList();
    }
    public void createEvent(EventDto eventDto){
        Event event= Event.builder()
                .dateAndTime(eventDto.getDateAndTime())
                .description(eventDto.getDescription())
                .name(eventDto.getName())
                .build();
        eventDao.createEvent(event);
    }

}
