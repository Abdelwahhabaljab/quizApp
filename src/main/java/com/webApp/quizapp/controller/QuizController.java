package com.webApp.quizapp.controller;

import com.webApp.quizapp.model.Question;
import com.webApp.quizapp.model.Quiz;
import com.webApp.quizapp.model.QuizWrapper;
import com.webApp.quizapp.model.Response;
import com.webApp.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")

public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return  quizService.create(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuizWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submiQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }
}
