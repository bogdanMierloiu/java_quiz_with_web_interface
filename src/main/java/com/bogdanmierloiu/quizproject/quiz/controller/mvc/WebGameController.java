package com.bogdanmierloiu.quizproject.quiz.controller.mvc;

import com.bogdanmierloiu.quizproject.quiz.dto.GameRequest;
import com.bogdanmierloiu.quizproject.quiz.dto.IdRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Answer;
import com.bogdanmierloiu.quizproject.quiz.entity.Game;
import com.bogdanmierloiu.quizproject.quiz.entity.Player;
import com.bogdanmierloiu.quizproject.quiz.entity.Question;
import com.bogdanmierloiu.quizproject.quiz.repository.AnswerRepository;
import com.bogdanmierloiu.quizproject.quiz.repository.PlayerRepository;
import com.bogdanmierloiu.quizproject.quiz.service.GameService;
import com.bogdanmierloiu.quizproject.quiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebGameController {
    private final GameService gameService;
    private final AnswerRepository answerRepository;

    private final QuestionService questionService;
    private final PlayerRepository playerRepository;


    @PostMapping("/game/play")
    public String play(@ModelAttribute GameRequest gameRequest, Model model) {
        Game game = gameService.add(gameRequest);
        for (Question question : game.getQuestions()) {
            for (Answer answer : question.getAnswers()) {
                answer.setIsSelectedByUser(true);
            }
        }
        model.addAttribute("score", game.getScore());
        model.addAttribute("currentGame", game);
        model.addAttribute("player", game.getPlayer());
        return "resultPage";
    }

    @GetMapping("/play-again")
    public String playAgain(@ModelAttribute IdRequest request, Model model) {
        Player player = playerRepository.findById(request.getId()).orElseThrow();
        GameRequest gameRequest = new GameRequest();
        List<Question> questions = questionService.randomList();
        model.addAttribute("questionsList", questions);
        model.addAttribute("player", player);
        model.addAttribute("gameRequest", gameRequest);
        return "gamePage";
    }
}
