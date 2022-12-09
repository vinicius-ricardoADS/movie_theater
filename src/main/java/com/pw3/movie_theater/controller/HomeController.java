package com.pw3.movie_theater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/index")
    public String getIndex1() {
        return "redirect:/";
    }
    
    @GetMapping("/")
    public String getIndex2() {
        return "/home/index";
    }
}
