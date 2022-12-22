package com.chappy.portfolio1.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chappy.portfolio1.book.models.Chat;
import com.chappy.portfolio1.book.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
    List<Message> findByChat(Chat chat);
}
