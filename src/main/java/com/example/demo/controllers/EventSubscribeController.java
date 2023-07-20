package com.example.demo.controllers;

import com.example.demo.dto.EventSubscribeDto;
import com.example.demo.service.EventSubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/subscribe")
@RequiredArgsConstructor
public class EventSubscribeController {
    private final EventSubscribeService eventSubscribeService;

    @PostMapping
    public HttpStatus subscribeToEvent(EventSubscribeDto eventSubscribeDto) {
        eventSubscribeDto.setRegistrationDate(LocalDateTime.now());
        return eventSubscribeService.subscribeToEvent(eventSubscribeDto);

    }
}
