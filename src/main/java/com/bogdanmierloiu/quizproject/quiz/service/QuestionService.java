package com.bogdanmierloiu.quizproject.quiz.service;

import com.bogdanmierloiu.quizproject.quiz.dto.QuestionRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Question;
import com.bogdanmierloiu.quizproject.quiz.repository.CategoryRepository;
import com.bogdanmierloiu.quizproject.quiz.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;

    public Question add(QuestionRequest questionRequest) {
        Question question = new Question();
        question.setText(questionRequest.getText());
        question.setCategory(categoryRepository.findById(questionRequest.getCategoryId()).orElseThrow());
        return questionRepository.save(question);
    }

    public List<Question> randomList() {
        List<Question> allQuestions = questionRepository.randomList();
        Collections.shuffle(allQuestions);
        return allQuestions.stream().limit(18).toList();
    }
}
