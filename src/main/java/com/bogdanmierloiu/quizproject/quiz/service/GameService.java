package com.bogdanmierloiu.quizproject.quiz.service;

import com.bogdanmierloiu.quizproject.quiz.dto.AnswerRequest;
import com.bogdanmierloiu.quizproject.quiz.dto.GameRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Answer;
import com.bogdanmierloiu.quizproject.quiz.entity.Game;
import com.bogdanmierloiu.quizproject.quiz.entity.Question;
import com.bogdanmierloiu.quizproject.quiz.repository.AnswerRepository;
import com.bogdanmierloiu.quizproject.quiz.repository.GameRepository;
import com.bogdanmierloiu.quizproject.quiz.repository.PlayerRepository;
import com.bogdanmierloiu.quizproject.quiz.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    private final QuestionService questionService;

    private final AnswerRepository answerRepository;

    public Game add(GameRequest gameRequest) {
        Game game = new Game();
        game.setPlayer(playerRepository.findById(gameRequest.getPlayerId()).orElseThrow());
        List<Question> questionList = questionService.randomList();
        game.getQuestions().addAll(questionList);

        List<Answer> answersFromUser = new ArrayList<>();
        for (Integer answerId : gameRequest.getAnswersId()) {
            Answer answer = answerRepository.findById(answerId).orElseThrow();
            answersFromUser.add(answer);
        }
        double score = 1.0;
        for (Answer answer : answersFromUser) {
            if (answer.getIsCorrect()) {
                score +=  0.5;
            }
        }
        game.setScore(score);
        return gameRepository.save(game);
    }
}
