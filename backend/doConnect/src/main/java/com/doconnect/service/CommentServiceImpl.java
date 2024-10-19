package com.doconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doconnect.model.Answer;
import com.doconnect.model.Comment;
import com.doconnect.repository.AnswerRepository;
import com.doconnect.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Comment createComment(Long answerId, Comment comment) {
        Answer answer = answerRepository.findById(answerId).orElseThrow(() -> new RuntimeException("Answer not found"));
        comment.setAnswer(answer);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsForAnswer(Long answerId) {
        return commentRepository.findByAnswerId(answerId);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @Override
    public Comment updateComment(Long answerId, Long id, Comment comment) {
        Comment existingComment = getCommentById(id);
        existingComment.setContent(comment.getContent());
        return commentRepository.save(existingComment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}

