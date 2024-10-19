package com.doconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doconnect.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByAnswerId(Long answerId);
}

