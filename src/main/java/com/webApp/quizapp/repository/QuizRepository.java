package com.webApp.quizapp.repository;

import com.webApp.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}
