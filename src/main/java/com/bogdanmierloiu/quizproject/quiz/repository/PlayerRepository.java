package com.bogdanmierloiu.quizproject.quiz.repository;

import com.bogdanmierloiu.quizproject.quiz.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
