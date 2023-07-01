package com.nishanthpkashyap.quizapp.dao;

import com.nishanthpkashyap.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    public List<Question> getAllQuestions();
}
