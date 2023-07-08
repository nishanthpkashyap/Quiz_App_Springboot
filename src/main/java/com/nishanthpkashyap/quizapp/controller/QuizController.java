package com.nishanthpkashyap.quizapp.controller;

import com.nishanthpkashyap.quizapp.model.QuestionWrapper;
import com.nishanthpkashyap.quizapp.model.Questions;
import com.nishanthpkashyap.quizapp.model.Quiz;
import com.nishanthpkashyap.quizapp.model.Response;
import com.nishanthpkashyap.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/get/{id}")
    private ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> response){
        return quizService.calculateQuizResult(id, response);
    }
}
