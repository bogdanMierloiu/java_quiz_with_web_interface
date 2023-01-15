package com.bogdanmierloiu.quizproject.quiz.controller.rest;

import com.bogdanmierloiu.quizproject.quiz.dto.AnswerRequest;
import com.bogdanmierloiu.quizproject.quiz.dto.GameRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Answer;
import com.bogdanmierloiu.quizproject.quiz.entity.Game;
import com.bogdanmierloiu.quizproject.quiz.service.AnswerService;
import com.bogdanmierloiu.quizproject.quiz.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping("/add")
    public Game add(@RequestBody GameRequest game) {
        return gameService.add(game);
    }
}
