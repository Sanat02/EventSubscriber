package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class EventDto {
    private int id;
    private LocalDateTime dateAndTime;
    private String name;
    private String description;
}
