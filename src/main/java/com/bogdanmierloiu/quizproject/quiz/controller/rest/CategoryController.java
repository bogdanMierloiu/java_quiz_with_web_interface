package com.bogdanmierloiu.quizproject.quiz.controller.rest;

import com.bogdanmierloiu.quizproject.quiz.entity.Category;
import com.bogdanmierloiu.quizproject.quiz.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public Category add(@RequestBody Category category) {
        return categoryService.add(category);
    }
}
