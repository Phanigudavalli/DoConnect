package com.doconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doconnect.model.Question;
import com.doconnect.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        Question existingQuestion = getQuestionById(id);
        existingQuestion.setTitle(question.getTitle());
        existingQuestion.setContent(question.getContent());
        return questionRepository.save(existingQuestion);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> searchQuestions(String keyword) {
        return questionRepository.findByTitleContaining(keyword);
    }
}

