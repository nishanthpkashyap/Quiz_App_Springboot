package com.nishanthpkashyap.quizapp.controller;

import com.nishanthpkashyap.quizapp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nishanthpkashyap.quizapp.service.QuestionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/allQuestions", method = RequestMethod.GET)
    public ResponseEntity<List<Questions>> getAllQuestions() {
          return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Questions>> getQuestionsById(@PathVariable int id){
        return questionService.getQuestionsById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String>  addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }

    //to update existing question
    @PutMapping("/update")
    public ResponseEntity<String> updateQuestion(@RequestBody Questions question){
        return questionService.updateQuestion(question);
    }
}
