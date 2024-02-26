package com.microservice.microservice.repository;

import com.microservice.microservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
