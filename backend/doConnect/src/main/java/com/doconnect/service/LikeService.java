package com.doconnect.service;

import java.util.List;

import com.doconnect.model.User;

public interface LikeService {
    void likeAnswer(Long answerId);
    void likeQuestion(Long questionId);
    void likeComment(Long commentId);
    List<User> getUsersWhoLikedAnswer(Long answerId);
    List<User> getUsersWhoLikedQuestion(Long questionId);
    List<User> getUsersWhoLikedComment(Long commentId);
}

