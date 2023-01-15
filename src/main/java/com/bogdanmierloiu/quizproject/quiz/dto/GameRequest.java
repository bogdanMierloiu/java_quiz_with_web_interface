package com.bogdanmierloiu.quizproject.quiz.dto;

import com.bogdanmierloiu.quizproject.quiz.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRequest {
    private Integer id;
    private Integer playerId;
    List<Integer> answersId = new ArrayList<>();


}
