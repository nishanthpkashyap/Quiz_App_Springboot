package com.nishanthpkashyap.quizapp.service;

import com.nishanthpkashyap.quizapp.dao.QuestionDao;
import com.nishanthpkashyap.quizapp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Questions>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category){
        try{
            String new_category = category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
            return new ResponseEntity<>(questionDao.getByCategory(new_category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Optional<Questions>> getQuestionsById(int id) {
        try{

            return new ResponseEntity<>(questionDao.findById(id), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(questionDao.findById(id), HttpStatus.NOT_FOUND);

        }
    }

    public ResponseEntity<String> addQuestion(Questions question){
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<String> deleteQuestion(int id){
        try{
            questionDao.deleteById(id);
            return new ResponseEntity<>(id + " deleted", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete " + id, HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<String> updateQuestion(Questions question) {
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Update success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
    }
}
