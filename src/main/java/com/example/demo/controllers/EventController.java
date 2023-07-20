package com.example.demo.controllers;

import com.example.demo.dto.EventDto;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    public List<EventDto> getAllEvents(){
        log.info("Get all events");
        return eventService.getAllEvents();
    }




}
