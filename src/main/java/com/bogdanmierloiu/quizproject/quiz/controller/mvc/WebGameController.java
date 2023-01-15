package com.bogdanmierloiu.quizproject.quiz.controller.mvc;

import com.bogdanmierloiu.quizproject.quiz.dto.GameRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Game;
import com.bogdanmierloiu.quizproject.quiz.entity.Question;
import com.bogdanmierloiu.quizproject.quiz.service.GameService;
import com.bogdanmierloiu.quizproject.quiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebGameController {
    private final GameService gameService;



    @PostMapping("/game/play")
    public String play(@ModelAttribute GameRequest gameRequest, Model model) {
        Game game = gameService.add(gameRequest);
        model.addAttribute("score", game.getScore());
        return "resultPage";
    }
}
