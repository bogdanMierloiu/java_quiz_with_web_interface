package com.bogdanmierloiu.quizproject.quiz.dto;

import com.bogdanmierloiu.quizproject.quiz.entity.Question;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Data
public class AnswerRequest {

    private Integer id;

    private String text;

    private Boolean isCorrect;

    private Integer questionId;

}
