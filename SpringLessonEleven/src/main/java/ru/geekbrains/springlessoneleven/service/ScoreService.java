package ru.geekbrains.springlessoneleven.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.springlessoneleven.models.Score;
import ru.geekbrains.springlessoneleven.repository.ScoreRepository;

@Service
@AllArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final UserService userService;

    public Score findScoreByUserName(String userName){
        Score score = userService.findUserByName(userName).getScore();
        setUserName(score);
        return score;
    }

    public Score findScoreByUserId(int id){
        Score score = userService.findUserById(id).getScore();
        setUserName(score);
        return score;
    }

    public Score changeScore(String userName, int amount){
        Score score = userService.findUserByName(userName).getScore();
        score.setUserScore(score.getUserScore()+amount);
        scoreRepository.save(score);
        setUserName(score);
        return score;
    }

    private void setUserName(Score score){
        score.setUserName(userService.findUserById(score.getUserId()).getName());
    }

}
