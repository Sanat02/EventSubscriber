package com.example.demo.controllers;

import com.example.demo.dto.EventDto;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    public List<EventDto> getAllEvents(){
        return eventService.getAllEvents();
    }

    @PostMapping
    public void createEvent(@RequestBody EventDto eventDto) {
        eventDto.setDateAndTime(LocalDateTime.now());
        eventService.createEvent(eventDto);
    }


}
