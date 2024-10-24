package com.doconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doconnect.model.Comment;
import com.doconnect.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/answers/{answerId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@PathVariable Long answerId, @RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(answerId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long answerId) {
        List<Comment> comments = commentService.getCommentsForAnswer(answerId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long answerId, @PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long answerId, @PathVariable Long id, @RequestBody Comment comment) {
        Comment updatedComment = commentService.updateComment(answerId, id, comment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long answerId, @PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
