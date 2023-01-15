package com.bogdanmierloiu.quizproject.quiz.controller.rest;

import com.bogdanmierloiu.quizproject.quiz.dto.AnswerRequest;
import com.bogdanmierloiu.quizproject.quiz.dto.IdRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Answer;
import com.bogdanmierloiu.quizproject.quiz.entity.Player;
import com.bogdanmierloiu.quizproject.quiz.service.AnswerService;
import com.bogdanmierloiu.quizproject.quiz.service.PlayersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayersService playersService;

    @PostMapping("/add")
    public Player add(@RequestBody Player player) {
        return playersService.add(player);
    }

    @GetMapping("/find")
    public Player findById(@RequestBody IdRequest request) {
        return playersService.findById(request);
    }
}
