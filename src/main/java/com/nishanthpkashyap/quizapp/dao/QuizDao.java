package com.nishanthpkashyap.quizapp.dao;

import com.nishanthpkashyap.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
