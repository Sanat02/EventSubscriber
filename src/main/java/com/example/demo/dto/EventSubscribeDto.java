package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventSubscribeDto {
    private Integer id;
    private int eventId;
    private String email;
    private LocalDateTime registrationDate;
}
