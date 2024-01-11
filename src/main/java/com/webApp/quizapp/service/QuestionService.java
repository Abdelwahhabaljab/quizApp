package com.webApp.quizapp.service;

import com.webApp.quizapp.model.Question;
import com.webApp.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question> >getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findAllByCategory(category),HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {

         questionRepository.save(question);
         return new  ResponseEntity<>("Success",HttpStatus.CREATED);

    }
}
