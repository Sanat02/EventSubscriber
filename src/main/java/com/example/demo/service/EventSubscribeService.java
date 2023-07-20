package com.example.demo.service;

import com.example.demo.dao.EventDao;
import com.example.demo.dao.EventSubscribeDao;
import com.example.demo.dto.EventSubscribeDto;
import com.example.demo.models.Event;
import com.example.demo.models.EventSubscribers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventSubscribeService {
    private final EventSubscribeDao eventSubscribeDao;
    private final EventService eventService;

    public String subscribeToEvent(EventSubscribeDto eventSubscribeDto) {
        if (eventService.getEventById(eventSubscribeDto.getEventId()) == null) {
            return "This id does not exists!";
        }
        LocalDateTime eventDateTime = eventService.getEventById(eventSubscribeDto.
                getEventId()).getDateAndTime();
        if (eventDateTime.isBefore(LocalDateTime.now())) {
            return "Date is expired!";
        } else {
            if (eventSubscribeDao.getByIdAndEmail(eventSubscribeDto.getEventId(), eventSubscribeDto.getEmail()) != null) {
                return "You already registered to the event with id:" + eventSubscribeDto.getEventId();
            }

            EventSubscribers eventSubscribers = EventSubscribers.builder()
                    .email(eventSubscribeDto.getEmail())
                    .registrationDate(eventSubscribeDto.getRegistrationDate())
                    .eventId(eventSubscribeDto.getEventId())
                    .build();
            return eventSubscribeDao.subscribeEvent(eventSubscribers);
        }

    }

    public List<EventSubscribeDto> getSubscribersByEmail(String email) {
        List<EventSubscribers> eventSubscribers = eventSubscribeDao.getSubscribersByEmail(email);
        return eventSubscribers.stream()
                .map(e -> EventSubscribeDto.builder()
                        .id(e.getId())
                        .eventId(e.getEventId())
                        .email(e.getEmail())
                        .registrationDate(e.getRegistrationDate())
                        .build()
                ).toList();

    }

    public String deleteSubscriber(int id,String email) {
        return eventSubscribeDao.deleteSubscriber(id,email);
    }
}
