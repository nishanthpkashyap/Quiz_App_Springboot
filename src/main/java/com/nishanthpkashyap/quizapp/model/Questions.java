package com.nishanthpkashyap.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Questions {
    @Id
    // Auto generates value for the primary key - id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
    private String correctOption;
}
