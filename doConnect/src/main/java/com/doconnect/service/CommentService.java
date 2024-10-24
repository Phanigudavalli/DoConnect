package com.doconnect.service;

import java.util.List;

import com.doconnect.model.Comment;

public interface CommentService {
    Comment createComment(Long answerId, Comment comment);
    List<Comment> getCommentsForAnswer(Long answerId);
    Comment getCommentById(Long id);
    Comment updateComment(Long answerId, Long id, Comment comment);
    void deleteComment(Long id);
}

