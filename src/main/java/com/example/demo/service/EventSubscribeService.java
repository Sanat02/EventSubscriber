package com.example.demo.service;

import com.example.demo.dao.EventSubscribeDao;
import com.example.demo.dto.EventSubscribeDto;
import com.example.demo.models.EventSubscribers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventSubscribeService {
    private final EventSubscribeDao eventSubscribeDao;

    public HttpStatus subscribeToEvent(EventSubscribeDto eventSubscribeDto) {
        EventSubscribers eventSubscribers = EventSubscribers.builder()
                .email(eventSubscribeDto.getEmail())
                .registrationDate(eventSubscribeDto.getRegistrationDate())
                .eventId(eventSubscribeDto.getEventId())
                .build();
        return eventSubscribeDao.subscribeEvent(eventSubscribers);

    }
}
