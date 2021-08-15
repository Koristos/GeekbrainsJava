package ru.geekbrains.springlessoneleven.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;

@Entity
@Table(name = "score")
@NoArgsConstructor
@Data
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score")
    private int id;
    @Column(name = "score_count")
    private int userScore;
    @Column(name = "user_id")
    private int userId;
    @Transient
    private String userName;
}
