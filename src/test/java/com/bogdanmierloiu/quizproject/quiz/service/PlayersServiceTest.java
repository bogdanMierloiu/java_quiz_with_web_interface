package com.bogdanmierloiu.quizproject.quiz.service;

import com.bogdanmierloiu.quizproject.quiz.entity.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayersServiceTest {
    @Test
    void create() {
        PlayersService playerService = Mockito.mock(PlayersService.class);
        Player player = new Player();
        player.setUsername("Bogdan");
        player.setEmail("bogdan@gmail.com");
        playerService.add(player);
    }
}