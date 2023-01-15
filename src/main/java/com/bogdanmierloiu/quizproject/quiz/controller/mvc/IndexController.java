package com.bogdanmierloiu.quizproject.quiz.controller.mvc;

import com.bogdanmierloiu.quizproject.quiz.dto.GameRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Player;
import com.bogdanmierloiu.quizproject.quiz.entity.Question;
import com.bogdanmierloiu.quizproject.quiz.service.PlayersService;
import com.bogdanmierloiu.quizproject.quiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final QuestionService questionService;
    private final PlayersService playersService;

    @GetMapping
    public String goToIndex() {
        return "index";
    }

    @PostMapping("/add-user")
    public String goToGamePage(@ModelAttribute Player playerRequest, Model model) {
        Player player = playersService.add(playerRequest);
        GameRequest gameRequest = new GameRequest();
        List<Question> questions = questionService.randomList();
        model.addAttribute("questionsList", questions);
        model.addAttribute("player", player);
        model.addAttribute("gameRequest", gameRequest);
        return "gamePage";
    }

}

