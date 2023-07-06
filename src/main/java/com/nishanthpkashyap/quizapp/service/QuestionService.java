package com.nishanthpkashyap.quizapp.service;

import com.nishanthpkashyap.quizapp.dao.QuestionDao;
import com.nishanthpkashyap.quizapp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Questions> getAllQuestions(){
        return questionDao.findAll();
    }

    public List<Questions> getQuestionsByCategory(String category){
        String new_category = category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
        return questionDao.getByCategory(new_category);
    }

    public Optional<Questions> getQuestionsById(int id) {
        return questionDao.findById(id);
    }

    public String addQuestion(Questions question){
        questionDao.save(question);
        return "Success";
    }
}
