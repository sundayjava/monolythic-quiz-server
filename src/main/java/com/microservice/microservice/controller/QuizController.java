package com.microservice.microservice.controller;

import com.microservice.microservice.model.QuestionWrapper;
import com.microservice.microservice.model.QuizRequestBody;
import com.microservice.microservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Long id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> subMitQuiz(@PathVariable Long id, @RequestBody List<QuizRequestBody> quizRequestBody) {
        return quizService.calculateResult(id, quizRequestBody);
    }
}
