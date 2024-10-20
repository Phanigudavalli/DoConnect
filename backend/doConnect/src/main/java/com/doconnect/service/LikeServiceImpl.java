package com.doconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doconnect.model.Answer;
import com.doconnect.model.Comment;
import com.doconnect.model.Like;
import com.doconnect.model.Question;
import com.doconnect.model.User;
import com.doconnect.repository.AnswerRepository;
import com.doconnect.repository.CommentRepository;
import com.doconnect.repository.LikeRepository;
import com.doconnect.repository.QuestionRepository;
import com.doconnect.repository.UserRepository;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private AnswerRepository answerRepository;
    
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository; 

    @Override
    public void likeAnswer(Long answerId) {
        Answer answer = answerRepository.findById(answerId).orElseThrow(() -> new RuntimeException("Answer not found"));
        Like like = new Like();
        like.setAnswer(answer);
       likeRepository.save(like);
    }

    @Override
    public void likeQuestion(Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
        Like like = new Like();
        like.setQuestion(question);
       likeRepository.save(like);
    }

    @Override
    public void likeComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Comment not found"));
        Like like = new Like();
        like.setComment(comment);
        likeRepository.save(like);
    }

    @Override
    public List<User> getUsersWhoLikedAnswer(Long answerId) {
        return likeRepository.findUsersWhoLikedAnswer(answerId);
    }

    @Override
    public List<User> getUsersWhoLikedQuestion(Long questionId) {
        return likeRepository.findUsersWhoLikedQuestion(questionId);
    }

    @Override
    public List<User> getUsersWhoLikedComment(Long commentId) {
        return likeRepository.findUsersWhoLikedComment(commentId);
    }
}
