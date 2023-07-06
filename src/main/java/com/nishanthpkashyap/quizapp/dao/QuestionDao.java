package com.nishanthpkashyap.quizapp.dao;

import com.nishanthpkashyap.quizapp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {
    public List<Questions> getByCategory(String category);
}
