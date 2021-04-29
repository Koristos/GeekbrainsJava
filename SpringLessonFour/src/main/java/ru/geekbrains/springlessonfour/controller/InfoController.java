package ru.geekbrains.springlessonfour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/info")
public class InfoController {

    @GetMapping
    @ModelAttribute("message")
    public String showInfo(@RequestParam String message){
        return message;
    }
}
