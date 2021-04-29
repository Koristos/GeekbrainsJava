package ru.geekbrains.springlessonfour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

    @RequestMapping
    public String mainPage(){
        return "index";
    }

}
