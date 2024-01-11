package com.webApp.quizapp.controller;

import com.webApp.quizapp.model.Question;
import com.webApp.quizapp.service.QuestionService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity <List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();

    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }

    }

