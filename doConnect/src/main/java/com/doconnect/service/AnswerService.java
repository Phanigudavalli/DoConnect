package com.doconnect.service;

import java.util.List;

import com.doconnect.model.Answer;

public interface AnswerService {
    Answer createAnswer(Long questionId, Answer answer);
    List<Answer> getAnswersForQuestion(Long questionId);
    Answer getAnswerById(Long id);
    Answer updateAnswer(Long questionId, Long id, Answer answer);
    void deleteAnswer(Long id);
}

