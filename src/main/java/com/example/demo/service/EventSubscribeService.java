package com.example.demo.service;

import com.example.demo.dao.EventDao;
import com.example.demo.dao.EventSubscribeDao;
import com.example.demo.dto.EventSubscribeDto;
import com.example.demo.models.EventSubscribers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventSubscribeService {
    private final EventSubscribeDao eventSubscribeDao;
    private final EventDao eventDao;

    public HttpStatus subscribeToEvent(EventSubscribeDto eventSubscribeDto) {
        if (eventDao.getEventById(eventSubscribeDto.getEventId()) == null) {
            return HttpStatus.NOT_FOUND;
        }
        LocalDateTime eventDateTime = eventDao.getEventById(eventSubscribeDto.
                getEventId()).getDateAndTime();
        if (eventDateTime.isBefore(LocalDateTime.now())) {
            return HttpStatus.FORBIDDEN;
        }
        EventSubscribers eventSubscribers = EventSubscribers.builder()
                .email(eventSubscribeDto.getEmail())
                .registrationDate(eventSubscribeDto.getRegistrationDate())
                .eventId(eventSubscribeDto.getEventId())
                .build();
        return eventSubscribeDao.subscribeEvent(eventSubscribers);

    }
}
