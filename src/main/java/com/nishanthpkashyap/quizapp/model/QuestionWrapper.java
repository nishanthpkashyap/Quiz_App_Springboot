package com.nishanthpkashyap.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuestionWrapper {
    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(Questions q){
        this.id = q.getId();
        this.option1 = q.getOption1();
        this.option2 = q.getOption2();
        this.option3 = q.getOption3();
        this.option4 = q.getOption4();
        this.questionTitle = q.getQuestionTitle();
    }

}
