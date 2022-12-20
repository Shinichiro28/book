package com.chappy.portfolio1.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chappy.portfolio1.book.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    
}
