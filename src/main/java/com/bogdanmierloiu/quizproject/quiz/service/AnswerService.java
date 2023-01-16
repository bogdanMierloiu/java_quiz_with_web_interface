package com.bogdanmierloiu.quizproject.quiz.service;

import com.bogdanmierloiu.quizproject.quiz.dto.AnswerRequest;
import com.bogdanmierloiu.quizproject.quiz.dto.UpdateAnswerText;
import com.bogdanmierloiu.quizproject.quiz.entity.Answer;
import com.bogdanmierloiu.quizproject.quiz.entity.Player;
import com.bogdanmierloiu.quizproject.quiz.repository.AnswerRepository;
import com.bogdanmierloiu.quizproject.quiz.repository.PlayerRepository;
import com.bogdanmierloiu.quizproject.quiz.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public Answer add(AnswerRequest answerRequest) {
        Answer answer = new Answer();
        answer.setText(answerRequest.getText());
        answer.setIsCorrect(answerRequest.getIsCorrect());
        answer.setQuestion(questionRepository.findById(answerRequest.getQuestionId()).orElseThrow());
        return answerRepository.save(answer);
    }

    public void updateText(UpdateAnswerText request) {
        Answer answer = answerRepository.findById(request.getId()).orElseThrow();
        answer.setText(request.getText());
    }
}
