package com.bogdanmierloiu.quizproject.quiz.controller.rest;

import com.bogdanmierloiu.quizproject.quiz.dto.AnswerRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Answer;
import com.bogdanmierloiu.quizproject.quiz.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/add")
    public Answer add(@RequestBody AnswerRequest answer) {
        return answerService.add(answer);
    }
}
