package com.nishanthpkashyap.quizapp.service;

import com.nishanthpkashyap.quizapp.dao.QuestionDao;
import com.nishanthpkashyap.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;
    public List<Question> getAllQuestions(){
        return questionDao.getAllQuestions();
    }
}
