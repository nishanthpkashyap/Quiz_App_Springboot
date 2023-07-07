package com.nishanthpkashyap.quizapp.controller;

import com.nishanthpkashyap.quizapp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Questions> getAllQuestions() {
          return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/id/{idString}")
    public Optional<Questions> getQuestionsById(@PathVariable String idString){
        Integer id = Integer.parseInt(idString);
        System.out.println(id+id);
        return questionService.getQuestionsById(id);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/delete/{qId}")
    public String deleteQuestion(@PathVariable String qId){
        int id = Integer.parseInt(qId);
        return questionService.deleteQuestion(id);
    }

    //to update existing question
    @PutMapping("/update")
    public String updateQuestion(@RequestBody Questions question){
        return questionService.updateQuestion(question);
    }
}
