package com.bogdanmierloiu.quizproject.quiz.controller.rest;

import com.bogdanmierloiu.quizproject.quiz.dto.QuestionRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Answer;
import com.bogdanmierloiu.quizproject.quiz.entity.Question;
import com.bogdanmierloiu.quizproject.quiz.service.AnswerService;
import com.bogdanmierloiu.quizproject.quiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/add")
    public Question add(@RequestBody QuestionRequest question) {
        return questionService.add(question);
    }

    @GetMapping("/random-list")
    public List<Question> randomList() {
        return questionService.randomList();
    }
}
