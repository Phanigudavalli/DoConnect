package com.doconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doconnect.model.Answer;
import com.doconnect.model.Question;
import com.doconnect.repository.AnswerRepository;
import com.doconnect.repository.QuestionRepository;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Answer createAnswer(Long questionId, Answer answer) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAnswersForQuestion(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElseThrow(() -> new RuntimeException("Answer not found"));
    }

    @Override
    public Answer updateAnswer(Long questionId, Long id, Answer answer) {
        Answer existingAnswer = getAnswerById(id);
        existingAnswer.setContent(answer.getContent());
        return answerRepository.save(existingAnswer);
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }
}

