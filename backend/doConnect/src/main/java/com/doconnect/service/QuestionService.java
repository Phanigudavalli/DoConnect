package com.doconnect.service;

import java.util.List;

import com.doconnect.model.Question;

public interface QuestionService {
    Question createQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    Question updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
    List<Question> searchQuestions(String keyword);
}

