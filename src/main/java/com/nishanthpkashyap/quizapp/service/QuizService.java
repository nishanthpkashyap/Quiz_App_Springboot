package com.nishanthpkashyap.quizapp.service;

import com.nishanthpkashyap.quizapp.dao.QuestionDao;
import com.nishanthpkashyap.quizapp.dao.QuizDao;
import com.nishanthpkashyap.quizapp.model.Questions;
import com.nishanthpkashyap.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(int id, String title, String category, int noOfQuestions) {
        try{
            // Fetch number of rows equal to 'noOfQuestions' from "questions" table
            List<Questions> questionList = questionDao.findRandomQuestionsByCategory(category, noOfQuestions);

            // create a obj of Quiz
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestionsList(questionList);

            // insert quiz into table "quiz"
            quizDao.save(quiz);

            return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Quiz not created", HttpStatus.BAD_REQUEST);
        }

    }
}
