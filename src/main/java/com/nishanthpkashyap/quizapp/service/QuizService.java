package com.nishanthpkashyap.quizapp.service;

import com.nishanthpkashyap.quizapp.dao.QuestionDao;
import com.nishanthpkashyap.quizapp.dao.QuizDao;
import com.nishanthpkashyap.quizapp.model.QuestionWrapper;
import com.nishanthpkashyap.quizapp.model.Questions;
import com.nishanthpkashyap.quizapp.model.Quiz;
import com.nishanthpkashyap.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        try{
            Optional<Quiz> quiz = quizDao.findById(id);
            List<Questions> questionList = quiz.orElseThrow().getQuestionsList();
            List<QuestionWrapper> questionsForUser = new ArrayList<>();
            for(Questions q: questionList){
                QuestionWrapper qw = new QuestionWrapper(q);
                questionsForUser.add(qw);
            }
            return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }

    public ResponseEntity<Integer> calculateQuizResult(int id, List<Response> response) {
        try{
            Quiz quiz = quizDao.findById(id).get(); //use chained .get() or use Optional<> like shown in the above method
            List<Questions> questionList = quiz.getQuestionsList();
            int result = 0;
            for(Questions q: questionList){
                for(Response r : response){
                    if(q.getId() == r.getId() && Objects.equals(q.getCorrectOption(), r.getResponse()))
                        result++;
                }
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}
