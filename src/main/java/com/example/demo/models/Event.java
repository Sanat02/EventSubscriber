package com.example.demo.models;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Event {
    private Integer id;
    private LocalDateTime dateAndTime;
    private String name;
    private String description;







}
