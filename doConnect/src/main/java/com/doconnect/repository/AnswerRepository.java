package com.doconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doconnect.model.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);
}
