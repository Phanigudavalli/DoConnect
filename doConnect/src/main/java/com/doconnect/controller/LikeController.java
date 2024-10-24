package com.doconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doconnect.model.User;
import com.doconnect.service.LikeService;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/answers/{answerId}")
    public ResponseEntity<Void> likeAnswer(@PathVariable Long answerId) {
        likeService.likeAnswer(answerId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/questions/{questionId}")
    public ResponseEntity<Void> likeQuestion(@PathVariable Long questionId) {
        likeService.likeQuestion(questionId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/comments/{commentId}")
    public ResponseEntity<Void> likeComment(@PathVariable Long commentId) {
        likeService.likeComment(commentId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/answers/{answerId}/users")
    public ResponseEntity<List<User>> getUsersWhoLikedAnswer(@PathVariable Long answerId) {
        List<User> users = likeService.getUsersWhoLikedAnswer(answerId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/questions/{questionId}/users")
    public ResponseEntity<List<User>> getUsersWhoLikedQuestion(@PathVariable Long questionId) {
        List<User> users = likeService.getUsersWhoLikedQuestion(questionId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/comments/{commentId}/users")
    public ResponseEntity<List<User>> getUsersWhoLikedComment(@PathVariable Long commentId) {
        List<User> users = likeService.getUsersWhoLikedComment(commentId);
        return ResponseEntity.ok(users);
    }
}
