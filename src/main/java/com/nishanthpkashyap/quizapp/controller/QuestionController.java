package com.nishanthpkashyap.quizapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @RequestMapping(value = "/allQuestions", method = RequestMethod.GET)
    public String getAllQuestions() {
        return "Hello, newbie";
    }
}
