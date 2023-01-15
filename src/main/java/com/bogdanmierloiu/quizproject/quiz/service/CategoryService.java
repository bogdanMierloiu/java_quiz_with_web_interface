package com.bogdanmierloiu.quizproject.quiz.service;

import com.bogdanmierloiu.quizproject.quiz.entity.Category;
import com.bogdanmierloiu.quizproject.quiz.entity.Player;
import com.bogdanmierloiu.quizproject.quiz.repository.CategoryRepository;
import com.bogdanmierloiu.quizproject.quiz.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category add(Category categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }


}
