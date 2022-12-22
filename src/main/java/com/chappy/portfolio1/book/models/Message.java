package com.chappy.portfolio1.book.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private Long chatId;

    @NotBlank
    private String text;

    private LocalDateTime timestamp;
}
