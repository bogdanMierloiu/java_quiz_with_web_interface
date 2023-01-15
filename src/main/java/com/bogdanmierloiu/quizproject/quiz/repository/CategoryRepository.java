package com.bogdanmierloiu.quizproject.quiz.repository;

import com.bogdanmierloiu.quizproject.quiz.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
