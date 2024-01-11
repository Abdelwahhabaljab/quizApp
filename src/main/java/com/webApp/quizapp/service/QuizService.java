package com.webApp.quizapp.service;

import com.webApp.quizapp.model.Question;
import com.webApp.quizapp.model.Quiz;
import com.webApp.quizapp.model.QuizWrapper;
import com.webApp.quizapp.model.Response;
import com.webApp.quizapp.repository.QuestionRepository;
import com.webApp.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> create(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuizWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestions();
        List<QuizWrapper> questionsForUser=new ArrayList<>();
        for (Question q :questionsFromDB){
            QuizWrapper qw=new QuizWrapper(q.getId(),q.getQuestion_title(), q.getOption1(), q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);

        }
        return new  ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        List<Question> questions =quiz.get().getQuestions();
        int right=0;
        int i=0;
        for (Response response :responses){
            if(response.getResponse().equals(questions.get(i).getRight_answer()))
                right++;
            i++;

        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}
