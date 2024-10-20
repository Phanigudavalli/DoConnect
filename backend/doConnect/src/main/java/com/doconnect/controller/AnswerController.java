package com.doconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doconnect.model.Answer;
import com.doconnect.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping("/api/questions/{questionId}/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@PathVariable Long questionId, @RequestBody Answer answer) {
        Answer createdAnswer = answerService.createAnswer(questionId, answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAnswers(@PathVariable Long questionId) {
        List<Answer> answers = answerService.getAnswersForQuestion(questionId);
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswer(@PathVariable Long questionId, @PathVariable Long id) {
        Answer answer = answerService.getAnswerById(id);
        return ResponseEntity.ok(answer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Long questionId, @PathVariable Long id, @RequestBody Answer answer) {
        Answer updatedAnswer = answerService.updateAnswer(questionId, id, answer);
        return ResponseEntity.ok(updatedAnswer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long questionId, @PathVariable Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}

