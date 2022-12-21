package com.chappy.portfolio1.book.models;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Message {
    
    private Long id;

    private Long chatId;

    private String text;

    private LocalDateTime timestamp;
}
