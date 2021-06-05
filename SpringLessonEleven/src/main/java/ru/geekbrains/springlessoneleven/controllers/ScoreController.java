package ru.geekbrains.springlessoneleven.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springlessoneleven.models.Score;
import ru.geekbrains.springlessoneleven.service.ScoreService;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/app/score")
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("/get/current")
    public Score getScore (Principal principal){
        return scoreService.findScoreByUserName(principal.getName());
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/get/{id}")
    public Score getScoreByUserId (@PathVariable int id){
        return scoreService.findScoreByUserId(id);
    }

    @GetMapping("/inc")
    public Score incScore (Principal principal){
        return scoreService.changeScore(principal.getName(), 1);
    }

    @GetMapping("/dec")
    public Score decScore (Principal principal){
        return scoreService.changeScore(principal.getName(), -1);
    }
}
