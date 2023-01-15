package com.bogdanmierloiu.quizproject.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "games")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Player player;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "games_questions",
    joinColumns = {@JoinColumn(name="game_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "id")})
    @ToString.Exclude
    private List<Question> questions = new ArrayList<>();
    private Double score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Game game = (Game) o;
        return id != null && Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
