package com.bogdanmierloiu.quizproject.quiz.service;

import com.bogdanmierloiu.quizproject.quiz.dto.IdRequest;
import com.bogdanmierloiu.quizproject.quiz.entity.Player;
import com.bogdanmierloiu.quizproject.quiz.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayersService {
    private final PlayerRepository playerRepository;

    public Player add(Player playerRequest) {
        Player player = new Player();
        player.setUsername(playerRequest.getUsername());
        player.setEmail(playerRequest.getEmail());
        return playerRepository.save(player);
    }

    public Player findById(IdRequest request) {
        return playerRepository.findById(request.getId()).orElseThrow();
    }
}
