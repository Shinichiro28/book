package com.chappy.portfolio1.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chappy.portfolio1.book.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}
