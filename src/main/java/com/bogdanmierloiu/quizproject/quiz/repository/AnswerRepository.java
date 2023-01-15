package com.bogdanmierloiu.quizproject.quiz.repository;

import com.bogdanmierloiu.quizproject.quiz.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
