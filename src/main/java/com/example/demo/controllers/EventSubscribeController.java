package com.example.demo.controllers;

import com.example.demo.dto.EventSubscribeDto;
import com.example.demo.service.EventSubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/subscribers")
@RequiredArgsConstructor
public class EventSubscribeController {
    private final EventSubscribeService eventSubscribeService;

    @PostMapping
    public String subscribeToEvent(EventSubscribeDto eventSubscribeDto) {
        eventSubscribeDto.setRegistrationDate(LocalDateTime.now());
        return eventSubscribeService.subscribeToEvent(eventSubscribeDto);

    }

    @GetMapping("/email/{email}")
    public List<EventSubscribeDto> getSubscribersByEmail(@PathVariable String email){
        return eventSubscribeService.getSubscribersByEmail(email);
    }

    @DeleteMapping("/email/{email}/id/{id}")
    public String deleteSubscriber(@PathVariable String email,@PathVariable int id) {
        return eventSubscribeService.deleteSubscriber(id,email);

    }
}
