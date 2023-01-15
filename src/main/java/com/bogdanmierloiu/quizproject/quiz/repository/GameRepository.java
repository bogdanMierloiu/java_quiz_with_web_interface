package com.bogdanmierloiu.quizproject.quiz.repository;

import com.bogdanmierloiu.quizproject.quiz.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
