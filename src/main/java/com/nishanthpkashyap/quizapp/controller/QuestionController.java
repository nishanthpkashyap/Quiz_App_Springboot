package com.nishanthpkashyap.quizapp.controller;

import com.nishanthpkashyap.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nishanthpkashyap.quizapp.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/allQuestions", method = RequestMethod.GET)
    public List<Question> getAllQuestions() {
//        return "Hello, newbie";
          return questionService.getAllQuestions();
    }
}
