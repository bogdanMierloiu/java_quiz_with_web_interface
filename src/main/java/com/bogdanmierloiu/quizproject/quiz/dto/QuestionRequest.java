package com.bogdanmierloiu.quizproject.quiz.dto;

import lombok.Data;

@Data
public class QuestionRequest {

    private Integer id;
    private String text;
    private Integer categoryId;


}
