package com.bogdanmierloiu.quizproject.quiz.repository;

import com.bogdanmierloiu.quizproject.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("select t from questions t left join fetch t.answers")
    List<Question> randomList();
}
