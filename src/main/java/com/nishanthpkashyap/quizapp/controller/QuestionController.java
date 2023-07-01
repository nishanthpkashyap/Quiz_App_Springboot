package com.nishanthpkashyap.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nishanthpkashyap.quizapp.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/allQuestions", method = RequestMethod.GET)
    public String getAllQuestions() {
//        return "Hello, newbie";
          return questionService.getAllQuestions();
    }
}
