package com.example.demo.models;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventSubscribers {
    private int id;
    private int eventId;
    private String email;
    private LocalDateTime registrationDate;
}
