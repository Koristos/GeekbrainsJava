package ru.geekbrains.lessontwelve.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getCurrentUserName (Principal principal){
        return principal.getName();
    }

}
