package com.nishanthpkashyap.quizapp.controller;

import com.nishanthpkashyap.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody Map<String, Object> req){
        int noOfQuestions = Integer.parseInt((String)req.get("no_of_questions"));
        int id = Integer.parseInt((String)req.get("id"));
        String title = (String)req.get("title");
        String category = (String)req.get("category");
        return quizService.createQuiz(id, title, category, noOfQuestions);
    }
}
